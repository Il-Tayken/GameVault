package com.gamevault.gamelist.presentation

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.gamevault.common.AppPrefs
import com.gamevault.common.AppStrings
import com.gamevault.gamelist.domain.model.Game
import com.gamevault.gamelist.domain.model.Platform
import kotlinx.coroutines.launch

val SD  = Color(0xFF171A21); val SC  = Color(0xFF1E2328); val SB  = Color(0xFF1B2838)
val SA  = Color(0xFF66C0F4); val SGL = Color(0xFFA4D007); val ST  = Color(0xFFC7D5E0)
val SS  = Color(0xFF8F98A0); val FR  = Color(0xFFEF5350); val GLD = Color(0xFFFFD700)

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
    val s = state.strings  // localized strings, recomposes when language changes
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var showSearch by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    var showSort   by remember { mutableStateOf(false) }

    // Apply external prefs (from Settings) whenever they change
    LaunchedEffect(externalPrefs) { viewModel.onApplyPrefs(externalPrefs) }

    // About dialog
    if (state.showAboutDialog) {
        AlertDialog(onDismissRequest = viewModel::onDismissAboutDialog, containerColor = SC,
            title = { Text("GameVault", color = ST, fontWeight = FontWeight.Bold) },
            text = { Column {
                Text("v1.0.0  •  RAWG.io", color = SS, fontSize = 13.sp)
                Spacer(Modifier.height(4.dp))
                Text("Kotlin · Compose · SQLDelight", color = SS, fontSize = 13.sp)
            }},
            confirmButton = { TextButton(onClick = viewModel::onDismissAboutDialog) { Text("OK", color = SA) } })
    }

    // Sort bottom sheet
    if (showSort) {
        ModalBottomSheet(onDismissRequest = { showSort = false }, containerColor = SC) {
            Column(Modifier.padding(bottom = 32.dp)) {
                Text(s.sortTitle, color = ST, fontWeight = FontWeight.Bold, fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp))
                HorizontalDivider(color = SS.copy(alpha = 0.2f))

                // Раздел: Общая сортировка
                SortSectionLabel("📊 Общая")
                listOf(
                    SortOrder.RATING_DESC     to s.sortRatingDesc,
                    SortOrder.RATING_ASC      to s.sortRatingAsc,
                    SortOrder.NAME_ASC        to s.sortName,
                    SortOrder.RELEASE_DESC    to s.sortRelease,
                    SortOrder.METACRITIC_DESC to s.sortMetacritic,
                    SortOrder.PLAYTIME_DESC   to s.sortPlaytime,
                ).forEach { (sort, label) -> SortItem(label, sort, state.sortOrder) { viewModel.onSortSelected(sort); showSort = false } }

                Spacer(Modifier.height(8.dp))
                HorizontalDivider(color = SS.copy(alpha = 0.15f), modifier = Modifier.padding(horizontal = 16.dp))

                // Раздел: По магазину
                SortSectionLabel("🛒 По магазину")
                listOf(
                    SortOrder.STORE_STEAM to s.sortSteam,
                    SortOrder.STORE_EPIC  to s.sortEpic,
                    SortOrder.STORE_PS    to s.sortPS,
                    SortOrder.STORE_XBOX  to s.sortXbox,
                ).forEach { (sort, label) -> SortItem(label, sort, state.sortOrder) { viewModel.onSortSelected(sort); showSort = false } }

                Spacer(Modifier.height(8.dp))
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            GameVaultDrawer(
                activeSection = state.activeDrawerSection,
                isCompact = state.prefs.isCompact,
                strings = s,
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
                                    Text(when (state.activeDrawerSection) {
                                        DrawerSection.FAVOURITES -> s.favourites
                                        DrawerSection.DISCOVER   -> s.discover
                                        else -> s.gameVault
                                    }, color = ST, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                }
                            }
                        },
                        actions = {
                            if (!showSearch) {
                                // Show active sort badge
                                if (state.sortOrder != SortOrder.RATING_DESC) {
                                    Surface(shape = RoundedCornerShape(6.dp), color = SA.copy(0.2f),
                                        modifier = Modifier.padding(end = 2.dp)) {
                                        Text(sortBadge(state.sortOrder), color = SA, fontSize = 10.sp,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp))
                                    }
                                }
                                IconButton(onClick = { showSearch = true }) { Icon(Icons.Default.Search, null, tint = ST) }
                                IconButton(onClick = { showSort = true }) { Icon(Icons.Default.Sort, null, tint = if (state.sortOrder != SortOrder.RATING_DESC) SA else ST) }
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
                    if (!state.showFavouritesOnly && !showSearch) {
                        PlatformRow(state.selectedPlatform, s, viewModel::onPlatformSelected)
                    }
                    if (!state.showFavouritesOnly && !showSearch && state.availableGenres.size > 1) {
                        GenreRow(state.availableGenres, state.selectedGenre, viewModel::onGenreSelected)
                    }
                    // Active store filter banner
                    if (state.sortOrder in listOf(SortOrder.STORE_STEAM, SortOrder.STORE_EPIC, SortOrder.STORE_PS, SortOrder.STORE_XBOX)) {
                        Surface(color = SA.copy(0.12f), modifier = Modifier.fillMaxWidth()) {
                            Row(Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(storeBannerText(state.sortOrder), color = SA, fontSize = 12.sp)
                                TextButton(onClick = { viewModel.onSortSelected(SortOrder.RATING_DESC) },
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)) {
                                    Text("✕", color = SA, fontSize = 12.sp)
                                }
                            }
                        }
                    }
                }
            }
        ) { padding ->
            val display = state.displayGames
            when {
                state.isLoading && state.allGames.isEmpty() -> LoadingState(s)
                state.showFavouritesOnly && display.isEmpty() -> EmptyFavourites(s)
                display.isEmpty() && state.allGames.isNotEmpty() -> EmptyFiltered(s)
                state.allGames.isEmpty() -> LoadingState(s)
                else -> {
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(if (state.prefs.isCompact) 6.dp else 12.dp),
                        modifier = Modifier.padding(padding)
                    ) {
                        val favs   = display.filter { it.isFavorite }
                        val others = display.filter { !it.isFavorite }

                        if (favs.isNotEmpty() && !state.showFavouritesOnly) {
                            item { SectionLabel(s.favourites, favs.size, s) }
                            items(favs, key = { "f_${it.id}" }) { game ->
                                GameCard(game, state.prefs, { onGameClick(game.id) }, { viewModel.onToggleFavorite(game.id, game.isFavorite) })
                            }
                            if (others.isNotEmpty()) item { SectionLabel(s.allGames, others.size, s) }
                        }
                        if (state.showFavouritesOnly) {
                            item { SectionLabel(s.favourites, display.size, s) }
                            items(display, key = { it.id }) { game ->
                                GameCard(game, state.prefs, { onGameClick(game.id) }, { viewModel.onToggleFavorite(game.id, game.isFavorite) })
                            }
                        } else {
                            items(others, key = { it.id }) { game ->
                                GameCard(game, state.prefs, { onGameClick(game.id) }, { viewModel.onToggleFavorite(game.id, game.isFavorite) })
                            }
                        }
                        if (state.isLoading) {
                            item { Box(Modifier.fillMaxWidth().padding(16.dp), Alignment.Center) { CircularProgressIndicator(color = SA, modifier = Modifier.size(24.dp)) } }
                        }
                        item { Spacer(Modifier.height(16.dp)) }
                    }
                }
            }
        }
    }
}

private fun sortBadge(sort: SortOrder) = when(sort) {
    SortOrder.STORE_STEAM    -> "Steam"
    SortOrder.STORE_EPIC     -> "Epic"
    SortOrder.STORE_PS       -> "PS"
    SortOrder.STORE_XBOX     -> "Xbox"
    SortOrder.METACRITIC_DESC-> "MC"
    SortOrder.PLAYTIME_DESC  -> "⏱"
    SortOrder.RELEASE_DESC   -> "NEW"
    SortOrder.NAME_ASC       -> "A-Z"
    SortOrder.RATING_ASC     -> "↑"
    else -> ""
}

private fun storeBannerText(sort: SortOrder) = when(sort) {
    SortOrder.STORE_STEAM -> "🖥 Фильтр: Steam (PC игры по рейтингу)"
    SortOrder.STORE_EPIC  -> "⚡ Фильтр: Epic Games (PC по Metacritic)"
    SortOrder.STORE_PS    -> "🎮 Фильтр: PlayStation игры"
    SortOrder.STORE_XBOX  -> "🟢 Фильтр: Xbox игры"
    else -> ""
}

// ── Sort sheet helpers ────────────────────────────────────────────
@Composable
fun SortSectionLabel(text: String) {
    Text(text, color = SS, fontSize = 11.sp, fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp))
}

@Composable
fun SortItem(label: String, sort: SortOrder, current: SortOrder, onClick: () -> Unit) {
    val selected = sort == current
    Row(modifier = Modifier.fillMaxWidth()
        .clickable(onClick = onClick)
        .background(if (selected) SA.copy(0.08f) else Color.Transparent)
        .padding(horizontal = 20.dp, vertical = 13.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = if (selected) SA else ST, fontSize = 14.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal)
        if (selected) Icon(Icons.Default.Check, null, tint = SA, modifier = Modifier.size(18.dp))
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
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(containerColor = SC),
        elevation = CardDefaults.cardElevation(4.dp)) {
        Column {
            Box(Modifier.fillMaxWidth().height(185.dp)) {
                AsyncImage(model = game.backgroundImage, contentDescription = game.name,
                    contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
                Box(Modifier.fillMaxWidth().height(100.dp).align(Alignment.BottomCenter)
                    .background(Brush.verticalGradient(listOf(Color.Transparent, SC))))
                if (prefs.showMetacritic) {
                    game.metacritic?.let { mc ->
                        Box(modifier = Modifier.align(Alignment.TopStart).padding(10.dp)
                            .background(when { mc >= 75 -> SGL; mc >= 50 -> Color(0xFFFFB300); else -> FR }, RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 3.dp)) {
                            Text(mc.toString(), color = SD, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                IconButton(onClick = onFav, modifier = Modifier.align(Alignment.TopEnd).padding(4.dp)) {
                    Icon(if (game.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        null, tint = if (game.isFavorite) FR else Color.White, modifier = Modifier.size(24.dp))
                }
                if (game.platforms.isNotEmpty()) {
                    Text(game.platforms.take(3).joinToString(" · "), color = SS, fontSize = 10.sp,
                        modifier = Modifier.align(Alignment.BottomStart).padding(10.dp))
                }
            }
            Row(Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text(game.name, color = ST, fontWeight = FontWeight.Bold, fontSize = 15.sp,
                        maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Spacer(Modifier.height(3.dp))
                    Text(game.genres.take(2).joinToString(" · ").ifBlank { "" },
                        color = SS, fontSize = 12.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                if (prefs.showRatings && game.rating > 0) {
                    Spacer(Modifier.width(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, null, tint = GLD, modifier = Modifier.size(15.dp))
                        Spacer(Modifier.width(3.dp))
                        Text(String.format("%.1f", game.rating), color = ST, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Composable
fun CompactCard(game: Game, prefs: AppPrefs, onClick: () -> Unit, onFav: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp), colors = CardDefaults.cardColors(containerColor = SC),
        elevation = CardDefaults.cardElevation(2.dp)) {
        Row(Modifier.height(68.dp)) {
            Box(Modifier.width(105.dp).fillMaxHeight()) {
                AsyncImage(model = game.backgroundImage, contentDescription = game.name,
                    contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
                Box(Modifier.fillMaxSize().background(
                    Brush.horizontalGradient(listOf(Color.Transparent, SC), startX = 55f, endX = 155f)))
                if (prefs.showMetacritic) {
                    game.metacritic?.let { mc ->
                        Box(Modifier.align(Alignment.TopStart).padding(4.dp)
                            .background(when { mc >= 75 -> SGL; mc >= 50 -> Color(0xFFFFB300); else -> FR }, RoundedCornerShape(3.dp))
                            .padding(horizontal = 4.dp, vertical = 1.dp)) {
                            Text(mc.toString(), color = SD, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
            Column(Modifier.weight(1f).fillMaxHeight().padding(horizontal = 10.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween) {
                Text(game.name, color = ST, fontWeight = FontWeight.SemiBold, fontSize = 13.sp,
                    maxLines = 2, overflow = TextOverflow.Ellipsis)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (prefs.showRatings && game.rating > 0) {
                        Icon(Icons.Default.Star, null, tint = GLD, modifier = Modifier.size(11.dp))
                        Spacer(Modifier.width(2.dp))
                        Text(String.format("%.1f", game.rating), color = ST, fontSize = 11.sp)
                        Spacer(Modifier.width(6.dp))
                    }
                    Text(game.genres.firstOrNull() ?: "", color = SS, fontSize = 10.sp,
                        maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }
            IconButton(onClick = onFav, modifier = Modifier.align(Alignment.CenterVertically).size(36.dp)) {
                Icon(if (game.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    null, tint = if (game.isFavorite) FR else SS, modifier = Modifier.size(16.dp))
            }
        }
    }
}

// ── Filter rows ───────────────────────────────────────────────────
@Composable
fun PlatformRow(selected: Platform, s: AppStrings, onSelect: (Platform) -> Unit) {
    val names = mapOf(
        Platform.ALL         to s.platformAll,
        Platform.PC          to "PC",
        Platform.PS5         to "PS5",
        Platform.PS4         to "PS4",
        Platform.XBOX_ONE    to "Xbox One",
        Platform.XBOX_SERIES to "Xbox Series",
        Platform.MOBILE      to s.platformMobile,
        Platform.NINTENDO    to "Nintendo"
    )
    LazyRow(Modifier.fillMaxWidth().background(SB).padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(Platform.entries.toTypedArray()) { p ->
            FilterChip(selected = p == selected, onClick = { onSelect(p) },
                label = { Text(names[p] ?: p.displayName, fontSize = 11.sp, color = if (p == selected) SD else ST) },
                colors = FilterChipDefaults.filterChipColors(selectedContainerColor = SA, containerColor = SC),
                border = FilterChipDefaults.filterChipBorder(enabled = true, selected = p == selected,
                    borderColor = SS.copy(0.3f), selectedBorderColor = SA))
        }
    }
}

@Composable
fun GenreRow(genres: List<String>, selected: String, onSelect: (String) -> Unit) {
    LazyRow(Modifier.fillMaxWidth().background(SD).padding(horizontal = 16.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(genres) { genre ->
            val isSel = genre == selected
            Surface(onClick = { onSelect(genre) }, shape = RoundedCornerShape(20.dp),
                color = if (isSel) SA.copy(0.2f) else SC,
                border = BorderStroke(1.dp, if (isSel) SA else SS.copy(0.3f))) {
                Text(genre, color = if (isSel) SA else SS, fontSize = 12.sp,
                    fontWeight = if (isSel) FontWeight.SemiBold else FontWeight.Normal,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp))
            }
        }
    }
}

// ── Empty/Loading ─────────────────────────────────────────────────
@Composable fun LoadingState(s: com.gamevault.common.AppStrings = com.gamevault.common.AppStrings.RU) = Box(Modifier.fillMaxSize(), Alignment.Center) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator(color = SA); Spacer(Modifier.height(16.dp))
        Text(s.loading, color = SS, fontSize = 14.sp)
    }
}
@Composable fun EmptyFavourites(s: com.gamevault.common.AppStrings = com.gamevault.common.AppStrings.RU) = Box(Modifier.fillMaxSize(), Alignment.Center) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Default.FavoriteBorder, null, tint = SS, modifier = Modifier.size(64.dp))
        Spacer(Modifier.height(16.dp)); Text(s.noFavs, color = ST, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp)); Text(s.tapHeart, color = SS, fontSize = 13.sp)
    }
}
@Composable fun EmptyFiltered(s: com.gamevault.common.AppStrings = com.gamevault.common.AppStrings.RU) = Box(Modifier.fillMaxSize(), Alignment.Center) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Default.FilterAlt, null, tint = SS, modifier = Modifier.size(56.dp))
        Spacer(Modifier.height(16.dp)); Text(s.noResults, color = ST, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable fun SectionLabel(title: String, count: Int, s: com.gamevault.common.AppStrings = com.gamevault.common.AppStrings.RU) {
    Row(Modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Text(title, color = ST, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Text("$count ${s.games}", color = SS, fontSize = 12.sp)
    }
}

// ── Drawer ────────────────────────────────────────────────────────
@Composable
fun GameVaultDrawer(activeSection: DrawerSection, isCompact: Boolean, strings: AppStrings = AppStrings.RU, onCompactToggle: () -> Unit, onSectionClick: (DrawerSection) -> Unit) {
    ModalDrawerSheet(drawerContainerColor = SC, modifier = Modifier.width(280.dp)) {
        Box(Modifier.fillMaxWidth().background(SB).padding(24.dp)) {
            Column {
                Box(Modifier.size(54.dp).clip(CircleShape).background(SA), Alignment.Center) {
                    Icon(Icons.Default.SportsEsports, null, tint = SD, modifier = Modifier.size(28.dp))
                }
                Spacer(Modifier.height(12.dp))
                Text("GameVault", color = ST, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Игровая библиотека", color = SS, fontSize = 12.sp)
            }
        }
        Spacer(Modifier.height(8.dp))
        DrawerBtn(Icons.Default.Home,     strings.home,       activeSection == DrawerSection.HOME)       { onSectionClick(DrawerSection.HOME) }
        DrawerBtn(Icons.Default.Favorite, strings.favourites.removePrefix("⭐ "), activeSection == DrawerSection.FAVOURITES) { onSectionClick(DrawerSection.FAVOURITES) }
        DrawerBtn(Icons.Default.Explore,  strings.discover.removePrefix("🔍 "),   activeSection == DrawerSection.DISCOVER)   { onSectionClick(DrawerSection.DISCOVER) }
        HorizontalDivider(color = SS.copy(0.15f), modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp).clickable(onClick = onCompactToggle),
            colors = CardDefaults.cardColors(containerColor = if (isCompact) SA.copy(0.12f) else Color.Transparent),
            shape = RoundedCornerShape(10.dp)) {
            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 11.dp),
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.ViewCompact, null, tint = if (isCompact) SA else SS, modifier = Modifier.size(20.dp))
                    Spacer(Modifier.width(14.dp))
                    Text(strings.compact, color = if (isCompact) SA else ST, fontSize = 14.sp)
                }
                Switch(checked = isCompact, onCheckedChange = { onCompactToggle() },
                    colors = SwitchDefaults.colors(checkedThumbColor = SD, checkedTrackColor = SA, uncheckedThumbColor = SS, uncheckedTrackColor = SC))
            }
        }
        DrawerBtn(Icons.Default.Settings, strings.settings,    activeSection == DrawerSection.SETTINGS) { onSectionClick(DrawerSection.SETTINGS) }
        DrawerBtn(Icons.Default.Info,     strings.about,        activeSection == DrawerSection.ABOUT)   { onSectionClick(DrawerSection.ABOUT) }
        Spacer(Modifier.weight(1f))
        Text("GameVault v1.0.0  •  RAWG API", color = SS.copy(0.5f), fontSize = 11.sp,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp))
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
