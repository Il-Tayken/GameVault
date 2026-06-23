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
import com.gamevault.gamelist.domain.model.StoreId
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

// Активная база данных
enum class GameSource { ALL, RAWG, STEAM, EPIC }

data class GameListUiState(
    val allGames: List<Game>           = emptyList(),
    val isLoading: Boolean             = false,
    val isSteamLoading: Boolean        = false,
    val isEpicLoading: Boolean         = false,
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
    val activeSource: GameSource       = GameSource.ALL,
    val steamCount: Int                = 0,
    val epicCount: Int                 = 0
) {
    val displayGames: List<Game> get() {
        var list = when {
            showFavouritesOnly -> allGames.filter { it.isFavorite }
            activeSource == GameSource.STEAM -> allGames.filter { it.source == "steam" || StoreId.STEAM in it.storeIds }
            activeSource == GameSource.EPIC  -> allGames.filter { it.source == "epic"  || StoreId.EPIC  in it.storeIds }
            activeSource == GameSource.RAWG  -> allGames.filter { it.source == "rawg" }
            else -> allGames
        }

        // Adult filter
        if (prefs.adultFilter) {
            val adultKeywords = setOf(
                "porn","hentai","xxx","nsfw","eroge","erotic",
                "nude","naked","lewd","ecchi","18+","sex simulator","mega porn"
            )
            val adultEsrb = setOf("adults-only","ao")
            list = list.filter { game ->
                val esrb = game.esrbRating?.lowercase() ?: ""
                if (adultEsrb.any { esrb.contains(it) }) return@filter false
                val nameLower = game.name.lowercase()
                if (adultKeywords.any { nameLower.contains(it) }) return@filter false
                val genresLower = game.genres.map { it.lowercase() }
                genresLower.none { g -> setOf("adult","eroge","hentai","nsfw").any { g.contains(it) } }
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

        // Platform filter (within source)
        if (selectedPlatform != Platform.ALL) {
            val ids = selectedPlatform.rawgId.split(",")
            list = list.filter { game ->
                game.platforms.any { p ->
                    ids.any { id ->
                        when (id) {
                            "4"   -> p.contains("PC", true) || p.contains("Windows", true)
                            "187" -> p.contains("PlayStation 5", true)
                            "18"  -> p.contains("PlayStation 4", true)
                            "1"   -> p.contains("Xbox One", true)
                            "186" -> p.contains("Xbox Series", true)
                            "7"   -> p.contains("Nintendo", true)
                            "3","21" -> p.contains("Android", true) || p.contains("iOS", true) || p.contains("mobile", true)
                            else  -> false
                        }
                    }
                }
            }
        }

        // Sort
        list = when (sortOrder) {
            SortOrder.RATING_DESC    -> list.sortedByDescending { it.rating }
            SortOrder.RATING_ASC     -> list.sortedBy { it.rating }
            SortOrder.NAME_ASC       -> list.sortedBy { it.name.lowercase() }
            SortOrder.RELEASE_DESC   -> list.sortedWith(compareByDescending<Game> { it.released ?: "" })
            SortOrder.METACRITIC_DESC-> list.sortedByDescending { it.metacritic ?: 0 }
            SortOrder.PLAYTIME_DESC  -> list.sortedByDescending { it.playtime }
            SortOrder.STORE_STEAM    -> list
                .filter { it.source == "steam" || StoreId.STEAM in it.storeIds || it.platforms.any { p -> p.contains("PC", true) } }
                .sortedByDescending { it.rating }
            SortOrder.STORE_EPIC     -> list
                .filter { it.source == "epic" || StoreId.EPIC in it.storeIds || it.platforms.any { p -> p.contains("PC", true) } }
                .sortedByDescending { it.metacritic ?: 0 }
            SortOrder.STORE_PS       -> list
                .filter { it.platforms.any { p -> p.contains("PlayStation", true) } }
                .sortedByDescending { it.rating }
            SortOrder.STORE_XBOX     -> list
                .filter { it.platforms.any { p -> p.contains("Xbox", true) } }
                .sortedByDescending { it.rating }
        }

        // Favorites always float to top
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

        observeAllGames()

        if (_uiState.value.prefs.autoRefresh) {
            refresh(Platform.ALL)
        }
        loadCacheSize()
    }

    fun onPlatformSelected(platform: Platform) {
        val allLabel = _uiState.value.strings.all
        _uiState.update { it.copy(selectedPlatform = platform, showFavouritesOnly = false, selectedGenre = allLabel) }
    }

    fun onSourceSelected(source: GameSource) {
        _uiState.update { it.copy(activeSource = source, showFavouritesOnly = false) }
        when (source) {
            GameSource.STEAM -> refreshSteam()
            GameSource.EPIC  -> refreshEpic()
            else -> {}
        }
    }

    fun onGenreSelected(genre: String)   = _uiState.update { it.copy(selectedGenre = genre) }
    fun onSortSelected(sort: SortOrder)  = _uiState.update { it.copy(sortOrder = sort) }
    fun onSearchQuery(q: String)         { _searchQuery.value = q }

    fun onToggleFavorite(id: Int, fav: Boolean) = viewModelScope.launch {
        toggleFavoriteUseCase(id, !fav)
        if (!fav && _uiState.value.prefs.notifications) {
            _uiState.value.allGames.find { it.id == id }?.let { game ->
                sendFavoriteNotification(game.name)
            }
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

    fun onRefresh() {
        refresh(_uiState.value.selectedPlatform)
        refreshSteam()
        refreshEpic()
    }

    fun onClearCache() {
        viewModelScope.launch {
            repository.clearCache()
            loadCacheSize()
            if (_uiState.value.prefs.autoRefresh) {
                refresh(_uiState.value.selectedPlatform)
            }
        }
    }

    fun onApplyPrefs(prefs: AppPrefs) {
        val strings = getStrings(prefs.language)
        val wasAutoRefresh = _uiState.value.prefs.autoRefresh
        _uiState.update { state ->
            val oldAll = state.strings.all
            val newGenre = if (state.selectedGenre.isBlank() || state.selectedGenre == oldAll) strings.all else state.selectedGenre
            val rawGenres = state.availableGenres.filter { it != oldAll }
            state.copy(
                prefs = prefs, strings = strings,
                selectedGenre = newGenre,
                availableGenres = listOf(strings.all) + rawGenres
            )
        }
        if (!wasAutoRefresh && prefs.autoRefresh) {
            refresh(_uiState.value.selectedPlatform)
        }
    }

    private fun observeAllGames() {
        getGamesUseCase(null).onEach { games ->
            val allLabel = _uiState.value.strings.all
            val rawGenres = games.flatMap { it.genres }.distinct().sorted()
            val steamCount = games.count { it.source == "steam" || StoreId.STEAM in it.storeIds }
            val epicCount = games.count { it.source == "epic" || StoreId.EPIC in it.storeIds }
            _uiState.update { state ->
                val genre = if (state.selectedGenre.isBlank()) allLabel else state.selectedGenre
                state.copy(
                    allGames = games,
                    availableGenres = listOf(allLabel) + rawGenres,
                    selectedGenre = genre,
                    steamCount = steamCount,
                    epicCount = epicCount
                )
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

    private fun refreshSteam() {
        viewModelScope.launch {
            _uiState.update { it.copy(isSteamLoading = true) }
            try {
                repository.refreshSteamGames()
                loadCacheSize()
            } catch (_: Exception) {}
            finally { _uiState.update { it.copy(isSteamLoading = false) } }
        }
    }

    private fun refreshEpic() {
        viewModelScope.launch {
            _uiState.update { it.copy(isEpicLoading = true) }
            try {
                repository.refreshEpicGames()
                loadCacheSize()
            } catch (_: Exception) {}
            finally { _uiState.update { it.copy(isEpicLoading = false) } }
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
                .setContentText("⭐ $gameName добавлено в избранное")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .build()
            nm.notify(gameName.hashCode(), notification)
        } catch (_: Exception) {}
    }
}
