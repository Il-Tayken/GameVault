package com.gamevault.gamelist.presentation

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamevault.common.AppPrefs
import com.gamevault.common.AppStrings
import com.gamevault.common.getStrings
import com.gamevault.gamelist.domain.model.Game
import com.gamevault.gamelist.domain.model.Platform
import com.gamevault.gamelist.domain.usecase.GetGamesUseCase
import com.gamevault.gamelist.domain.usecase.RefreshGamesUseCase
import com.gamevault.gamelist.domain.usecase.ToggleFavoriteUseCase
import com.gamevault.gamelist.domain.repository.GameListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class DrawerSection { HOME, FAVOURITES, DISCOVER, SETTINGS, ABOUT }
enum class SortOrder {
    RATING_DESC, RATING_ASC, NAME_ASC, RELEASE_DESC, METACRITIC_DESC, PLAYTIME_DESC,
    STORE_STEAM, STORE_EPIC, STORE_PS, STORE_XBOX
}

data class GameListUiState(
    val allGames: List<Game>           = emptyList(),
    val isLoading: Boolean             = false,
    val error: String?                 = null,
    val selectedPlatform: Platform     = Platform.ALL,
    val selectedGenre: String          = "",
    val availableGenres: List<String>  = emptyList(),
    val sortOrder: SortOrder           = SortOrder.RATING_DESC,
    val searchQuery: String            = "",
    val showFavouritesOnly: Boolean    = false,
    val activeDrawerSection: DrawerSection = DrawerSection.HOME,
    val showAboutDialog: Boolean       = false,
    val prefs: AppPrefs                = AppPrefs(),
    val strings: AppStrings            = AppStrings.RU,
    val cacheSize: Int                 = 0,
    val cacheClearedMessage: Boolean   = false
) {
    val displayGames: List<Game> get() {
        var list = if (showFavouritesOnly) allGames.filter { it.isFavorite } else allGames

        // Adult filter — three layers of filtering:
        if (prefs.adultFilter) {
            // 1. ESRB rating from RAWG (most accurate)
            val adultEsrb = setOf("adults-only", "mature", "ao")
            // 2. Keywords in game name
            val adultNameKeywords = setOf(
                "porn","hentai","xxx","nsfw","eroge","erotic",
                "nude","naked","lewd","ecchi","18+","mega porn",
                "adult game","sex simulator","hentai game"
            )
            // 3. Adult genres
            val adultGenres = setOf("adult","eroge","hentai","nsfw","adults only","erotic")

            list = list.filter { game ->
                // Block if ESRB says adults-only or mature (slug: "adults-only", "mature")
                val esrbSlug = game.esrbRating?.lowercase() ?: ""
                val blockedByEsrb = adultEsrb.any { esrbSlug.contains(it) }
                if (blockedByEsrb) return@filter false

                // Block by name keywords
                val nameLower = game.name.lowercase()
                val blockedByName = adultNameKeywords.any { kw -> nameLower.contains(kw) }
                if (blockedByName) return@filter false

                // Block by genre
                val genresLower = game.genres.map { it.lowercase() }
                val blockedByGenre = genresLower.any { g ->
                    adultGenres.any { ag -> g.contains(ag) }
                }
                !blockedByGenre
            }
        }

        // Search
        if (searchQuery.isNotBlank()) {
            val q = searchQuery.lowercase()
            list = list.filter {
                it.name.lowercase().contains(q) ||
                it.genres.any { g -> g.lowercase().contains(q) }
            }
        }

        // Genre filter
        val allLabel = strings.all
        if (selectedGenre.isNotBlank() && selectedGenre != allLabel) {
            list = list.filter { game ->
                game.genres.any { g -> g.equals(selectedGenre, ignoreCase = true) }
            }
        }

        // Sort
        list = when (sortOrder) {
            SortOrder.RATING_DESC    -> list.sortedByDescending { it.rating }
            SortOrder.RATING_ASC     -> list.sortedBy { it.rating }
            SortOrder.NAME_ASC       -> list.sortedBy { it.name }
            SortOrder.RELEASE_DESC   -> list.sortedByDescending { it.released ?: "" }
            SortOrder.METACRITIC_DESC-> list.sortedByDescending { it.metacritic ?: 0 }
            SortOrder.PLAYTIME_DESC  -> list.sortedByDescending { it.playtime }
            SortOrder.STORE_STEAM    -> list.filter { it.platforms.any { p -> p.contains("PC", true) } }.sortedByDescending { it.rating }
            SortOrder.STORE_EPIC     -> list.filter { it.platforms.any { p -> p.contains("PC", true) } }.sortedByDescending { it.metacritic ?: 0 }
            SortOrder.STORE_PS       -> list.filter { it.platforms.any { p -> p.contains("PlayStation", true) || p.contains("PS", true) } }.sortedByDescending { it.rating }
            SortOrder.STORE_XBOX     -> list.filter { it.platforms.any { p -> p.contains("Xbox", true) } }.sortedByDescending { it.rating }
        }

        return list.sortedByDescending { it.isFavorite }
    }
}

@OptIn(FlowPreview::class)
@HiltViewModel
class GameListViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val getGamesUseCase: GetGamesUseCase,
    private val refreshGamesUseCase: RefreshGamesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase,
    private val repository: GameListRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameListUiState())
    val uiState: StateFlow<GameListUiState> = _uiState.asStateFlow()
    private val _searchQuery = MutableStateFlow("")

    init {
        _searchQuery.debounce(300).onEach { q ->
            _uiState.update { it.copy(searchQuery = q) }
        }.launchIn(viewModelScope)
        observeGames(Platform.ALL)
        // Auto-refresh on start if enabled
        if (_uiState.value.prefs.autoRefresh) {
            refresh(Platform.ALL)
        }
        loadCacheSize()
    }

    fun onPlatformSelected(platform: Platform) {
        val allLabel = _uiState.value.strings.all
        _uiState.update { it.copy(selectedPlatform = platform, showFavouritesOnly = false, selectedGenre = allLabel) }
        observeGames(platform)
        refresh(platform)
    }

    fun onGenreSelected(genre: String)  = _uiState.update { it.copy(selectedGenre = genre) }
    fun onSortSelected(sort: SortOrder) = _uiState.update { it.copy(sortOrder = sort) }
    fun onSearchQuery(q: String)        { _searchQuery.value = q }
    fun onToggleFavorite(id: Int, fav: Boolean) = viewModelScope.launch {
        toggleFavoriteUseCase(id, !fav)
        // Send notification if enabled and adding to favorites
        if (!fav && _uiState.value.prefs.notifications) {
            val game = _uiState.value.allGames.find { it.id == id }
            game?.let { sendFavoriteNotification(it.name) }
        }
    }
    fun onToggleCompact() = _uiState.update { it.copy(prefs = it.prefs.copy(isCompact = !it.prefs.isCompact)) }

    fun onDrawerSectionSelected(section: DrawerSection) {
        _uiState.update { it.copy(activeDrawerSection = section) }
        when (section) {
            DrawerSection.HOME       -> _uiState.update { it.copy(showFavouritesOnly = false) }
            DrawerSection.FAVOURITES -> _uiState.update { it.copy(showFavouritesOnly = true) }
            DrawerSection.ABOUT      -> _uiState.update { it.copy(showAboutDialog = true) }
            else -> {}
        }
    }

    fun onDismissAboutDialog() = _uiState.update { it.copy(showAboutDialog = false) }
    fun onRefresh()            = refresh(_uiState.value.selectedPlatform)

    // ── Clear cache ───────────────────────────────────────────────
    fun onClearCache() {
        viewModelScope.launch {
            repository.clearCache()
            loadCacheSize()
            _uiState.update { it.copy(cacheClearedMessage = true) }
            // Auto-refresh after clearing
            if (_uiState.value.prefs.autoRefresh) {
                refresh(_uiState.value.selectedPlatform)
            }
        }
    }

    // ── Apply prefs ───────────────────────────────────────────────
    fun onApplyPrefs(prefs: AppPrefs) {
        val strings = getStrings(prefs.language)
        val wasAutoRefresh = _uiState.value.prefs.autoRefresh
        _uiState.update { state ->
            val oldAll   = state.strings.all
            val newGenre = if (state.selectedGenre.isBlank() || state.selectedGenre == oldAll) strings.all else state.selectedGenre
            val rawGenres = state.availableGenres.filter { it != oldAll }
            state.copy(
                prefs         = prefs,
                strings       = strings,
                selectedGenre = newGenre,
                availableGenres = listOf(strings.all) + rawGenres
            )
        }
        // If auto-refresh just turned ON — refresh now
        if (!wasAutoRefresh && prefs.autoRefresh) {
            refresh(_uiState.value.selectedPlatform)
        }
        // Request notification permission if turned ON (Android 13+)
        if (prefs.notifications && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestNotificationPermissionIfNeeded()
        }
    }

    // ── Private ───────────────────────────────────────────────────
    private fun observeGames(platform: Platform) {
        val platformId = platform.rawgId.takeIf { it.isNotBlank() }
        getGamesUseCase(platformId).onEach { games ->
            val allLabel  = _uiState.value.strings.all
            val rawGenres = games.flatMap { it.genres }.distinct().sorted()
            _uiState.update { state ->
                val genre = if (state.selectedGenre.isBlank()) allLabel else state.selectedGenre
                state.copy(allGames = games, availableGenres = listOf(allLabel) + rawGenres, selectedGenre = genre)
            }
        }.launchIn(viewModelScope)
    }

    private fun refresh(platform: Platform) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                repository.refreshGames(
                    platform = platform.rawgId.takeIf { it.isNotBlank() },
                    useCache = _uiState.value.prefs.cacheEnabled
                )
                loadCacheSize()
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.message) }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    private fun loadCacheSize() {
        viewModelScope.launch {
            val size = repository.getCacheSize()
            _uiState.update { it.copy(cacheSize = size) }
        }
    }

    private fun sendFavoriteNotification(gameName: String) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) return
            }
            val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notification = NotificationCompat.Builder(context, "gamevault_main")
                .setSmallIcon(android.R.drawable.star_on)
                .setContentTitle("GameVault")
                .setContentText("⭐ $gameName ${_uiState.value.strings.noFavs.replace("Нет избранных игр","").let { "добавлено в избранное" }}")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .build()
            nm.notify(gameName.hashCode(), notification)
        } catch (_: Exception) {}
    }

    private fun requestNotificationPermissionIfNeeded() {
        // Permission request is handled in MainActivity via Activity result API
        // Here we just check — actual request is in UI layer
    }
}
