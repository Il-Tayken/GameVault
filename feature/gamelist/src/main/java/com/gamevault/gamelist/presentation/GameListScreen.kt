package com.gamevault.gamelist.presentation

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.gamevault.common.AppPrefs
import com.gamevault.common.AppStrings
import com.gamevault.gamelist.domain.model.Game
import com.gamevault.gamelist.domain.model.Platform
import com.gamevault.gamelist.presentation.GameSource
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.rememberLazyListState

// ── Steam Dark палитра ────────────────────────────────────────────
val SD  = Color(0xFF171A21)   // фон
val SC  = Color(0xFF1E2328)   // карточки
val SB  = Color(0xFF1B2838)   // топбар
val SA  = Color(0xFF66C0F4)   // акцент синий
val SGL = Color(0xFFA4D007)   // зелёный (Metacritic хороший)
val ST  = Color(0xFFC7D5E0)   // основной текст
val SS  = Color(0xFF8F98A0)   // второстепенный текст
val FR  = Color(0xFFEF5350)   // красный (избранное/плохой MC)
val GLD = Color(0xFFFFD700)   // золото (звезда)
val AMB = Color(0xFFFFB300)   // янтарный (средний MC)
val SteamGreen  = Color(0xFF4CAF50)
val EpicPurple  = Color(0xFF9C27B0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameListScreen(
    externalPrefs: AppPrefs = AppPrefs(),
    onGameClick: (Int) -> Unit,
    onSettingsClick: (AppPrefs) -> Unit = {},
    onDiscoverClick: () -> Unit = {},
    onClearCacheRequest: (() -> Unit) -> Unit = {},
    viewModel: GameListViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val s = state.strings
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var showSearch by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    var showSort   by remember { mutableStateOf(false) }
    var showFilter by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()

    LaunchedEffect(externalPrefs) { viewModel.onApplyPrefs(externalPrefs) }

    // Scroll to top when sort or filters change
    LaunchedEffect(state.sortOrder, state.selectedPlatform, state.activeSource, state.selectedGenre) {
        listState.animateScrollToItem(0)
    }

    // About dialog
    if (state.showAboutDialog) {
        AlertDialog(onDismissRequest = viewModel::onDismissAboutDialog, containerColor = SC,
            title = { Text("GameVault", color = ST, fontWeight = FontWeight.Bold) },
            text = { Column {
                Text("v1.0.0  •  RAWG.io", color = SS, fontSize = 13.sp)
                Spacer(Modifier.height(4.dp))
                Text("Steam + Epic + RAWG базы данных", color = SS, fontSize = 13.sp)
            }},
            confirmButton = { TextButton(onClick = viewModel::onDismissAboutDialog) { Text("OK", color = SA) } })
    }

    // Sort sheet
    if (showSort) {
        ModalBottomSheet(onDismissRequest = { showSort = false }, containerColor = Color(0xFF13191F),
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
            Column(Modifier.padding(bottom = 32.dp)) {
                // Handle indicator
                Box(Modifier.fillMaxWidth(), Alignment.Center) {
                    Box(Modifier.size(40.dp, 4.dp).clip(CircleShape).background(SS.copy(0.4f)))
                }
                Spacer(Modifier.height(16.dp))
                Text(s.sortTitle, color = ST, fontWeight = FontWeight.Bold, fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp))
                HorizontalDivider(color = SS.copy(0.15f), modifier = Modifier.padding(vertical = 8.dp))

                SortSection("📊 ${s.sortGeneral}")
                listOf(
                    SortOrder.RATING_DESC     to s.sortRatingDesc,
                    SortOrder.RATING_ASC      to s.sortRatingAsc,
                    SortOrder.NAME_ASC        to s.sortName,
                    SortOrder.RELEASE_DESC    to s.sortRelease,
                    SortOrder.METACRITIC_DESC to s.sortMetacritic,
                    SortOrder.PLAYTIME_DESC   to s.sortPlaytime,
                ).forEach { (sort, label) ->
                    SortRow(label, sort, state.sortOrder, SA) { viewModel.onSortSelected(sort); showSort = false }
                }

                Spacer(Modifier.height(8.dp))
                HorizontalDivider(color = SS.copy(0.1f), modifier = Modifier.padding(horizontal = 16.dp))

                SortSection("🛒 ${s.sortByStore}")
                listOf(
                    Triple(SortOrder.STORE_STEAM, s.sortSteam, Color(0xFF1B2838)),
                    Triple(SortOrder.STORE_EPIC,  s.sortEpic,  Color(0xFF2D1B4E)),
                    Triple(SortOrder.STORE_PS,    s.sortPS,    Color(0xFF003087)),
                    Triple(SortOrder.STORE_XBOX,  s.sortXbox,  Color(0xFF107C10)),
                ).forEach { (sort, label, tint) ->
                    SortRow(label, sort, state.sortOrder, SA) { viewModel.onSortSelected(sort); showSort = false }
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }

    // Filter bottom sheet
    if (showFilter) {
        ModalBottomSheet(onDismissRequest = { showFilter = false }, containerColor = Color(0xFF13191F),
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)) {
            Column(Modifier.padding(bottom = 40.dp)) {
                Box(Modifier.fillMaxWidth(), Alignment.Center) {
                    Box(Modifier.size(40.dp, 4.dp).clip(CircleShape).background(SS.copy(0.4f)))
                }
                Spacer(Modifier.height(16.dp))
                Text("Фильтры", color = ST, fontWeight = FontWeight.Bold, fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp))
                HorizontalDivider(color = SS.copy(0.15f), modifier = Modifier.padding(vertical = 8.dp))

                // Platform filter
                Text("ПЛАТФОРМА", color = SA, fontSize = 11.sp, fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp))
                val platformNames = mapOf(
                    Platform.ALL to s.platformAll, Platform.PC to "PC",
                    Platform.PS5 to "PS5", Platform.PS4 to "PS4",
                    Platform.XBOX_ONE to "Xbox One", Platform.XBOX_SERIES to "Xbox Series",
                    Platform.MOBILE to s.platformMobile, Platform.NINTENDO to "Nintendo"
                )
                LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(Platform.entries.toTypedArray()) { p ->
                        PlatformChip(
                            label = platformNames[p] ?: p.displayName,
                            icon = platformIcon(p),
                            selected = state.selectedPlatform == p,
                            onClick = { viewModel.onPlatformSelected(p) }
                        )
                    }
                }

                Spacer(Modifier.height(16.dp))
                HorizontalDivider(color = SS.copy(0.1f), modifier = Modifier.padding(horizontal = 16.dp))

                // Source filter
                Text("ИСТОЧНИК", color = SA, fontSize = 11.sp, fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp))
                LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(listOf(
                        Triple(GameSource.ALL,   "🎮 Все",    null as Color?),
                        Triple(GameSource.STEAM, "🖥 Steam",  Color(0xFF1B96F0)),
                        Triple(GameSource.EPIC,  "⚡ Epic",   EpicPurple),
                        Triple(GameSource.RAWG,  "🌐 RAWG",  SA),
                    )) { (src, label, color) ->
                        SourceChip(
                            label = label,
                            count = when(src) { GameSource.STEAM -> state.steamCount; GameSource.EPIC -> state.epicCount; else -> null },
                            isLoading = (src == GameSource.STEAM && state.isSteamLoading) || (src == GameSource.EPIC && state.isEpicLoading),
                            selected = state.activeSource == src,
                            accentColor = color ?: SA,
                            onClick = { viewModel.onSourceSelected(src) }
                        )
                    }
                }

                Spacer(Modifier.height(16.dp))
                HorizontalDivider(color = SS.copy(0.1f), modifier = Modifier.padding(horizontal = 16.dp))

                // Genre filter
                if (state.availableGenres.size > 1) {
                    Text("ЖАНР", color = SA, fontSize = 11.sp, fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp))
                    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(state.availableGenres) { genre ->
                            GenreChip(genre, genre == state.selectedGenre) { viewModel.onGenreSelected(genre) }
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))
                // Reset button
                val hasFilters = state.selectedPlatform != Platform.ALL ||
                        state.activeSource != GameSource.ALL ||
                        (state.selectedGenre.isNotBlank() && state.selectedGenre != s.all)
                if (hasFilters) {
                    Button(
                        onClick = {
                            viewModel.onPlatformSelected(Platform.ALL)
                            viewModel.onSourceSelected(GameSource.ALL)
                            viewModel.onGenreSelected(s.all)
                            showFilter = false
                        },
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = FR.copy(0.15f)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(Icons.Default.FilterAltOff, null, tint = FR, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("Сбросить фильтры", color = FR, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            GameVaultDrawer(
                activeSection = state.activeDrawerSection,
                isCompact = state.prefs.isCompact,
                onCompactToggle = viewModel::onToggleCompact,
                onSectionClick = { section ->
                    viewModel.onDrawerSectionSelected(section)
                    scope.launch { drawerState.close() }
                    when (section) {
                        DrawerSection.SETTINGS -> {
                            onClearCacheRequest { viewModel.onClearCache() }
                            onSettingsClick(state.prefs)
                        }
                        DrawerSection.DISCOVER -> onDiscoverClick()
                        else -> {}
                    }
                }
            )
        }
    ) {
        Scaffold(
            containerColor = SD,
            topBar = {
                Column {
                    TopAppBar(
                        title = {
                            AnimatedContent(targetState = showSearch, label = "search") { searching ->
                                if (searching) {
                                    OutlinedTextField(
                                        value = searchText,
                                        onValueChange = { searchText = it; viewModel.onSearchQuery(it) },
                                        placeholder = { Text(s.search, color = SS, fontSize = 14.sp) },
                                        singleLine = true,
                                        modifier = Modifier.fillMaxWidth().height(50.dp),
                                        colors = OutlinedTextFieldDefaults.colors(
                                            focusedBorderColor = SA, unfocusedBorderColor = Color.Transparent,
                                            focusedTextColor = ST, unfocusedTextColor = ST, cursorColor = SA,
                                            focusedContainerColor = SC, unfocusedContainerColor = SC
                                        ),
                                        shape = RoundedCornerShape(10.dp),
                                        trailingIcon = {
                                            IconButton(onClick = { searchText = ""; viewModel.onSearchQuery(""); showSearch = false }) {
                                                Icon(Icons.Default.Close, null, tint = SS)
                                            }
                                        }
                                    )
                                } else {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(when (state.activeDrawerSection) {
                                            DrawerSection.FAVOURITES -> s.favourites
                                            DrawerSection.DISCOVER   -> s.discover
                                            else -> s.gameVault
                                        }, color = ST, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                        // Active source badge
                                        if (state.activeSource != GameSource.ALL) {
                                            Spacer(Modifier.width(8.dp))
                                            SourceBadge(state.activeSource)
                                        }
                                    }
                                }
                            }
                        },
                        actions = {
                            if (!showSearch) {
                                IconButton(onClick = { showSearch = true }) {
                                    Icon(Icons.Default.Search, null, tint = ST)
                                }
                                // Filter button with active indicator
                                val hasActiveFilter = state.selectedPlatform != Platform.ALL ||
                                        state.activeSource != GameSource.ALL ||
                                        (state.selectedGenre.isNotBlank() && state.selectedGenre != s.all)
                                Box {
                                    IconButton(onClick = { showFilter = true }) {
                                        Icon(Icons.Default.Tune, null,
                                            tint = if (hasActiveFilter) SA else ST)
                                    }
                                    if (hasActiveFilter) {
                                        Box(Modifier.size(8.dp).clip(CircleShape).background(FR)
                                            .align(Alignment.TopEnd).offset((-4).dp, 4.dp))
                                    }
                                }
                                IconButton(onClick = { showSort = true }) {
                                    Icon(Icons.Default.Sort, null,
                                        tint = if (state.sortOrder != SortOrder.RATING_DESC) SA else ST)
                                }
                                IconButton(onClick = viewModel::onToggleCompact) {
                                    Icon(if (state.prefs.isCompact) Icons.Default.ViewAgenda else Icons.Default.ViewCompact,
                                        null, tint = if (state.prefs.isCompact) SA else SS)
                                }
                                IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                    Icon(Icons.Default.Menu, null, tint = ST)
                                }
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = SB)
                    )

                    // Active filters bar
                    val hasActiveFilter = state.selectedPlatform != Platform.ALL ||
                            state.activeSource != GameSource.ALL ||
                            (state.selectedGenre.isNotBlank() && state.selectedGenre != s.all) ||
                            state.sortOrder != SortOrder.RATING_DESC
                    if (!showSearch && hasActiveFilter) {
                        ActiveFiltersBar(state, s,
                            onClearPlatform = { viewModel.onPlatformSelected(Platform.ALL) },
                            onClearSource   = { viewModel.onSourceSelected(GameSource.ALL) },
                            onClearGenre    = { viewModel.onGenreSelected(s.all) },
                            onClearSort     = { viewModel.onSortSelected(SortOrder.RATING_DESC) }
                        )
                    }
                }
            }
        ) { padding ->
            val display = state.displayGames
            when {
                (state.isLoading || state.isSteamLoading || state.isEpicLoading) && state.allGames.isEmpty() ->
                    LoadingState(s)
                state.showFavouritesOnly && display.isEmpty() -> EmptyFavourites(s)
                display.isEmpty() && state.allGames.isNotEmpty() -> EmptyFiltered(s)
                state.allGames.isEmpty() -> LoadingState(s)
                else -> {
                    LazyColumn(
                        state = listState,
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(if (state.prefs.isCompact) 6.dp else 10.dp),
                        modifier = Modifier.padding(padding)
                    ) {
                        val favs   = display.filter { it.isFavorite }
                        val others = display.filter { !it.isFavorite }

                        if (favs.isNotEmpty() && !state.showFavouritesOnly) {
                            item { SectionLabel(s.favourites, favs.size, s) }
                            items(favs, key = { "f_${it.id}" }) { game ->
                                GameCard(game, state.prefs, { onGameClick(game.id) },
                                    { viewModel.onToggleFavorite(game.id, game.isFavorite) })
                            }
                            if (others.isNotEmpty()) item { SectionLabel(s.allGames, others.size, s) }
                        }
                        if (state.showFavouritesOnly) {
                            item { SectionLabel(s.favourites, display.size, s) }
                            items(display, key = { it.id }) { game ->
                                GameCard(game, state.prefs, { onGameClick(game.id) },
                                    { viewModel.onToggleFavorite(game.id, game.isFavorite) })
                            }
                        } else {
                            items(others, key = { it.id }) { game ->
                                GameCard(game, state.prefs, { onGameClick(game.id) },
                                    { viewModel.onToggleFavorite(game.id, game.isFavorite) })
                            }
                        }
                        if (state.isLoading) {
                            item { Box(Modifier.fillMaxWidth().padding(16.dp), Alignment.Center) {
                                CircularProgressIndicator(color = SA, modifier = Modifier.size(24.dp))
                            }}
                        }
                        item { Spacer(Modifier.height(80.dp)) }
                    }
                }
            }
        }
    }
}

// ── Active filters bar ────────────────────────────────────────────
@Composable
fun ActiveFiltersBar(
    state: GameListUiState, s: AppStrings,
    onClearPlatform: () -> Unit, onClearSource: () -> Unit,
    onClearGenre: () -> Unit, onClearSort: () -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth().background(SB).padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        if (state.selectedPlatform != Platform.ALL) {
            item { ActiveFilterChip(state.selectedPlatform.displayName, onClearPlatform) }
        }
        if (state.activeSource != GameSource.ALL) {
            val label = when(state.activeSource) {
                GameSource.STEAM -> "Steam"; GameSource.EPIC -> "Epic"
                GameSource.RAWG -> "RAWG"; else -> ""
            }
            item { ActiveFilterChip(label, onClearSource) }
        }
        if (state.selectedGenre.isNotBlank() && state.selectedGenre != s.all) {
            item { ActiveFilterChip(state.selectedGenre, onClearGenre) }
        }
        if (state.sortOrder != SortOrder.RATING_DESC) {
            val sortLabel = when(state.sortOrder) {
                SortOrder.NAME_ASC -> "A-Z"; SortOrder.RATING_ASC -> "Рейтинг ↑"
                SortOrder.RELEASE_DESC -> "Новые"; SortOrder.METACRITIC_DESC -> "Metacritic"
                SortOrder.PLAYTIME_DESC -> "Playtime"; SortOrder.STORE_STEAM -> "Steam"
                SortOrder.STORE_EPIC -> "Epic"; SortOrder.STORE_PS -> "PS"
                SortOrder.STORE_XBOX -> "Xbox"; else -> ""
            }
            item { ActiveFilterChip("↕ $sortLabel", onClearSort) }
        }
    }
}

@Composable
fun ActiveFilterChip(label: String, onClear: () -> Unit) {
    Surface(shape = RoundedCornerShape(16.dp), color = SA.copy(0.15f),
        border = BorderStroke(1.dp, SA.copy(0.4f))) {
        Row(modifier = Modifier.padding(start = 10.dp, end = 6.dp, top = 5.dp, bottom = 5.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Text(label, color = SA, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.width(4.dp))
            Icon(Icons.Default.Close, null, tint = SA, modifier = Modifier.size(14.dp).clickable(onClick = onClear))
        }
    }
}

// ── Filter chips ──────────────────────────────────────────────────
@Composable
fun PlatformChip(label: String, icon: String, selected: Boolean, onClick: () -> Unit) {
    Surface(onClick = onClick, shape = RoundedCornerShape(12.dp),
        color = if (selected) SA else SC,
        border = if (selected) null else BorderStroke(1.dp, SS.copy(0.3f))) {
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(icon, fontSize = 20.sp)
            Spacer(Modifier.height(4.dp))
            Text(label, color = if (selected) SD else ST, fontSize = 11.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal)
        }
    }
}

fun platformIcon(p: Platform) = when(p) {
    Platform.ALL     -> "🎮"; Platform.PC -> "🖥"; Platform.PS5 -> "🎮"
    Platform.PS4     -> "🎮"; Platform.XBOX_ONE -> "🟢"; Platform.XBOX_SERIES -> "🟢"
    Platform.MOBILE  -> "📱"; Platform.NINTENDO -> "🟡"
}

@Composable
fun SourceChip(label: String, count: Int?, isLoading: Boolean, selected: Boolean,
    accentColor: Color, onClick: () -> Unit) {
    Surface(onClick = onClick, shape = RoundedCornerShape(12.dp),
        color = if (selected) accentColor.copy(0.25f) else SC,
        border = BorderStroke(1.5.dp, if (selected) accentColor else SS.copy(0.3f))) {
        Row(modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically) {
            if (isLoading) {
                CircularProgressIndicator(color = accentColor, modifier = Modifier.size(12.dp), strokeWidth = 2.dp)
                Spacer(Modifier.width(6.dp))
            }
            Text(label, color = if (selected) accentColor else ST, fontSize = 13.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal)
            if (count != null && count > 0) {
                Spacer(Modifier.width(6.dp))
                Surface(shape = CircleShape, color = accentColor.copy(0.2f)) {
                    Text("$count", color = accentColor, fontSize = 10.sp,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                }
            }
        }
    }
}

@Composable
fun GenreChip(genre: String, selected: Boolean, onClick: () -> Unit) {
    Surface(onClick = onClick, shape = RoundedCornerShape(20.dp),
        color = if (selected) SA.copy(0.2f) else SC,
        border = BorderStroke(1.dp, if (selected) SA else SS.copy(0.3f))) {
        Text(genre, color = if (selected) SA else SS, fontSize = 12.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp))
    }
}

@Composable
fun SourceBadge(source: GameSource) {
    val (label, color) = when(source) {
        GameSource.STEAM -> "Steam" to Color(0xFF1B96F0)
        GameSource.EPIC  -> "Epic"  to EpicPurple
        GameSource.RAWG  -> "RAWG"  to SA
        else             -> "" to SA
    }
    Surface(shape = RoundedCornerShape(6.dp), color = color.copy(0.2f),
        border = BorderStroke(1.dp, color.copy(0.5f))) {
        Text(label, color = color, fontSize = 11.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
    }
}

// ── Sort helpers ──────────────────────────────────────────────────
@Composable
fun SortSection(title: String) {
    Text(title, color = SS, fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp))
}

@Composable
fun SortRow(label: String, sort: SortOrder, current: SortOrder, accent: Color, onClick: () -> Unit) {
    val selected = sort == current
    Row(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick)
        .background(if (selected) accent.copy(0.08f) else Color.Transparent)
        .padding(horizontal = 20.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = if (selected) accent else ST, fontSize = 14.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal)
        if (selected) Box(Modifier.size(20.dp).clip(CircleShape).background(accent),
            Alignment.Center) {
            Icon(Icons.Default.Check, null, tint = SD, modifier = Modifier.size(13.dp))
        }
    }
}

// ── Cards ─────────────────────────────────────────────────────────
@Composable
fun GameCard(game: Game, prefs: AppPrefs, onClick: () -> Unit, onFav: () -> Unit) {
    if (prefs.isCompact) CompactCard(game, prefs, onClick, onFav)
    else BigCard(game, prefs, onClick, onFav)
}

@Composable
fun BigCard(game: Game, prefs: AppPrefs, onClick: () -> Unit, onFav: () -> Unit) {
    val sourceColor = when(game.source) {
        "steam" -> Color(0xFF1B96F0); "epic" -> EpicPurple; else -> SA
    }
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = SC),
        elevation = CardDefaults.cardElevation(4.dp)) {
        Column {
            Box(Modifier.fillMaxWidth().height(190.dp)) {
                AsyncImage(model = game.backgroundImage, contentDescription = game.name,
                    contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
                // Dark gradient
                Box(Modifier.fillMaxSize().background(
                    Brush.verticalGradient(listOf(Color.Transparent, Color.Transparent, SC.copy(0.9f)))))
                // Top row: Metacritic + Source badge + Favorite
                Row(Modifier.fillMaxWidth().align(Alignment.TopStart).padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        if (prefs.showMetacritic) {
                            game.metacritic?.let { mc ->
                                val mcColor = when { mc >= 75 -> SGL; mc >= 50 -> AMB; else -> FR }
                                Surface(shape = RoundedCornerShape(6.dp), color = mcColor) {
                                    Text(mc.toString(), color = Color(0xFF0D1117), fontSize = 11.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp))
                                }
                            }
                        }
                        // Source badge
                        val srcLabel = when(game.source) { "steam" -> "Steam"; "epic" -> "Epic"; else -> null }
                        srcLabel?.let {
                            Surface(shape = RoundedCornerShape(6.dp), color = sourceColor.copy(0.85f)) {
                                Text(it, color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp))
                            }
                        }
                    }
                    // Favorite button
                    Box(Modifier.size(34.dp).clip(CircleShape)
                        .background(if (game.isFavorite) FR.copy(0.15f) else Color.Black.copy(0.4f))
                        .clickable(onClick = onFav), Alignment.Center) {
                        Icon(if (game.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            null, tint = if (game.isFavorite) FR else Color.White,
                            modifier = Modifier.size(18.dp))
                    }
                }
                // Bottom info on image
                Column(Modifier.align(Alignment.BottomStart).padding(12.dp)) {
                    Text(game.name, color = Color.White, fontWeight = FontWeight.Bold,
                        fontSize = 16.sp, maxLines = 1, overflow = TextOverflow.Ellipsis,
                        style = LocalTextStyle.current.copy(
                            shadow = Shadow(Color.Black.copy(0.8f), blurRadius = 8f)))
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(game.genres.take(2).joinToString(" · ").ifBlank { "" },
                            color = ST.copy(0.85f), fontSize = 12.sp, maxLines = 1,
                            overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f))
                        if (prefs.showRatings && game.rating > 0) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Star, null, tint = GLD, modifier = Modifier.size(13.dp))
                                Spacer(Modifier.width(3.dp))
                                Text(String.format("%.1f", game.rating), color = Color.White,
                                    fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
            // Platforms row
            if (game.platforms.isNotEmpty()) {
                Text(game.platforms.take(3).joinToString(" · "), color = SS, fontSize = 10.sp,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), maxLines = 1,
                    overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

@Composable
fun CompactCard(game: Game, prefs: AppPrefs, onClick: () -> Unit, onFav: () -> Unit) {
    val sourceColor = when(game.source) { "steam" -> Color(0xFF1B96F0); "epic" -> EpicPurple; else -> SA }
    val mcColor = game.metacritic?.let { mc -> when { mc >= 75 -> SGL; mc >= 50 -> AMB; else -> FR } }

    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SC),
        elevation = CardDefaults.cardElevation(4.dp)) {
        Row(Modifier.height(88.dp)) {
            // Larger image
            Box(Modifier.width(130.dp).fillMaxHeight()) {
                AsyncImage(model = game.backgroundImage, contentDescription = game.name,
                    contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())

                // Colored left border — source indicator
                Box(Modifier.width(4.dp).fillMaxHeight().align(Alignment.CenterStart)
                    .background(Brush.verticalGradient(listOf(sourceColor.copy(0.8f), sourceColor))))
                // Metacritic top-left
                if (prefs.showMetacritic && mcColor != null) {
                    Box(Modifier.align(Alignment.TopStart).padding(start = 8.dp, top = 6.dp)
                        .background(mcColor, RoundedCornerShape(5.dp))
                        .padding(horizontal = 5.dp, vertical = 2.dp)) {
                        Text(game.metacritic.toString(), color = Color(0xFF0D1117),
                            fontSize = 10.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }
                // Source badge bottom-left
                val srcLabel = when(game.source) { "steam" -> "S"; "epic" -> "E"; else -> null }
                srcLabel?.let {
                    Box(Modifier.align(Alignment.BottomStart).padding(start = 8.dp, bottom = 6.dp)
                        .size(18.dp).clip(CircleShape).background(sourceColor),
                        contentAlignment = Alignment.Center) {
                        Text(it, color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
            // Info
            Column(Modifier.weight(1f).fillMaxHeight().padding(horizontal = 12.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(game.name, color = ST, fontWeight = FontWeight.Bold, fontSize = 14.sp,
                        maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Spacer(Modifier.height(3.dp))
                    Text(game.genres.take(2).joinToString(" · ").ifBlank { "" },
                        color = SS, fontSize = 11.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        if (prefs.showRatings && game.rating > 0) {
                            Icon(Icons.Default.Star, null, tint = GLD, modifier = Modifier.size(13.dp))
                            Text(String.format("%.1f", game.rating), color = ST, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        }
                        if (!game.released.isNullOrBlank()) {
                            Text("·", color = SS, fontSize = 11.sp)
                            Text(game.released.take(4), color = SS, fontSize = 11.sp)
                        }
                    }
                    // Playtime if available
                    if (game.playtime > 0) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Timer, null, tint = SS, modifier = Modifier.size(11.dp))
                            Spacer(Modifier.width(2.dp))
                            Text("${game.playtime}ч", color = SS, fontSize = 10.sp)
                        }
                    }
                }
            }
            // Favorite button — larger hit area
            Box(Modifier.width(48.dp).fillMaxHeight().clickable(onClick = onFav),
                contentAlignment = Alignment.Center) {
                Box(Modifier.size(32.dp).clip(CircleShape)
                    .background(if (game.isFavorite) FR.copy(0.15f) else Color.Transparent),
                    contentAlignment = Alignment.Center) {
                    Icon(if (game.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        null, tint = if (game.isFavorite) FR else SS.copy(0.7f),
                        modifier = Modifier.size(18.dp))
                }
            }
        }
    }
}

// ── Empty/Loading states ──────────────────────────────────────────
@Composable fun LoadingState(s: AppStrings) = Box(Modifier.fillMaxSize(), Alignment.Center) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator(color = SA, modifier = Modifier.size(48.dp), strokeWidth = 3.dp)
        Spacer(Modifier.height(16.dp))
        Text(s.loading, color = SS, fontSize = 14.sp)
    }
}
@Composable fun EmptyFavourites(s: AppStrings) = Box(Modifier.fillMaxSize(), Alignment.Center) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Default.FavoriteBorder, null, tint = SS, modifier = Modifier.size(72.dp))
        Spacer(Modifier.height(16.dp))
        Text(s.noFavs, color = ST, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))
        Text(s.tapHeart, color = SS, fontSize = 13.sp)
    }
}
@Composable fun EmptyFiltered(s: AppStrings) = Box(Modifier.fillMaxSize(), Alignment.Center) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Default.FilterAltOff, null, tint = SS, modifier = Modifier.size(64.dp))
        Spacer(Modifier.height(16.dp))
        Text(s.noResults, color = ST, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))
        Text("Попробуйте изменить фильтры", color = SS, fontSize = 13.sp)
    }
}

@Composable fun SectionLabel(title: String, count: Int, s: AppStrings) {
    Row(Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.width(3.dp).height(16.dp).clip(RoundedCornerShape(2.dp)).background(SA))
        Spacer(Modifier.width(8.dp))
        Text(title, color = ST, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        Surface(shape = RoundedCornerShape(10.dp), color = SA.copy(0.15f)) {
            Text("$count", color = SA, fontSize = 11.sp,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
        }
    }
}

// ── Drawer ────────────────────────────────────────────────────────
@Composable
fun GameVaultDrawer(activeSection: DrawerSection, isCompact: Boolean,
    onCompactToggle: () -> Unit, onSectionClick: (DrawerSection) -> Unit) {
    ModalDrawerSheet(drawerContainerColor = SC, modifier = Modifier.width(280.dp)) {
        Box(Modifier.fillMaxWidth().background(
            Brush.verticalGradient(listOf(SB, SD))).padding(24.dp)) {
            Column {
                Box(Modifier.size(56.dp).clip(RoundedCornerShape(16.dp)).background(SA), Alignment.Center) {
                    Icon(Icons.Default.SportsEsports, null, tint = SD, modifier = Modifier.size(30.dp))
                }
                Spacer(Modifier.height(12.dp))
                Text("GameVault", color = ST, fontSize = 22.sp, fontWeight = FontWeight.ExtraBold)
                Text("Игровая библиотека", color = SS, fontSize = 12.sp)
            }
        }
        Spacer(Modifier.height(8.dp))
        DrawerBtn(Icons.Default.Home,     "Главная",   activeSection == DrawerSection.HOME)       { onSectionClick(DrawerSection.HOME) }
        DrawerBtn(Icons.Default.Favorite, "Избранное", activeSection == DrawerSection.FAVOURITES) { onSectionClick(DrawerSection.FAVOURITES) }
        DrawerBtn(Icons.Default.Explore,  "Обзор",     activeSection == DrawerSection.DISCOVER)   { onSectionClick(DrawerSection.DISCOVER) }
        HorizontalDivider(color = SS.copy(0.12f), modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        // Compact switch
        Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp).clickable(onClick = onCompactToggle),
            colors = CardDefaults.cardColors(containerColor = if (isCompact) SA.copy(0.12f) else Color.Transparent),
            shape = RoundedCornerShape(12.dp)) {
            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.ViewCompact, null, tint = if (isCompact) SA else SS, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(14.dp))
                    Text("Компактный вид", color = if (isCompact) SA else ST, fontSize = 14.sp)
                }
                Switch(checked = isCompact, onCheckedChange = { onCompactToggle() },
                    colors = SwitchDefaults.colors(checkedThumbColor = SD, checkedTrackColor = SA, uncheckedThumbColor = SS, uncheckedTrackColor = SC))
            }
        }
        DrawerBtn(Icons.Default.Settings, "Настройки",    activeSection == DrawerSection.SETTINGS) { onSectionClick(DrawerSection.SETTINGS) }
        DrawerBtn(Icons.Default.Info,     "О приложении", activeSection == DrawerSection.ABOUT)    { onSectionClick(DrawerSection.ABOUT) }
        Spacer(Modifier.weight(1f))
        Text("GameVault v1.0.0  •  RAWG + Steam + Epic",
            color = SS.copy(0.5f), fontSize = 11.sp, modifier = Modifier.padding(20.dp))
    }
}

@Composable
fun DrawerBtn(icon: ImageVector, label: String, selected: Boolean, onClick: () -> Unit) {
    NavigationDrawerItem(
        icon = { Icon(icon, label, tint = if (selected) SD else SA) },
        label = { Text(label, color = if (selected) SD else ST, fontSize = 14.sp) },
        selected = selected, onClick = onClick,
        modifier = Modifier.padding(horizontal = 12.dp),
        colors = NavigationDrawerItemDefaults.colors(selectedContainerColor = SA, unselectedContainerColor = Color.Transparent)
    )
}
