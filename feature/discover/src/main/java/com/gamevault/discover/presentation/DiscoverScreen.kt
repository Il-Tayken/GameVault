package com.gamevault.discover.presentation

import com.gamevault.common.AppStrings
import com.gamevault.common.getStrings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.gamevault.discover.domain.model.DiscoverGame

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverScreen(onGameClick: (Int) -> Unit, onBackClick: () -> Unit, language: String = "Русский 🇷🇺", viewModel: DiscoverViewModel = hiltViewModel()) {
    val s = getStrings(language)
    val state  by viewModel.uiState.collectAsStateWithLifecycle()
    val primary = MaterialTheme.colorScheme.primary
    val bg      = MaterialTheme.colorScheme.background
    val surface = MaterialTheme.colorScheme.surface
    val onBg    = MaterialTheme.colorScheme.onBackground

    Scaffold(containerColor = bg,
        topBar = {
            TopAppBar(
                title = { Column {
                    Text(s.discoverTitle, color = onBg, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(s.discoverSub, color = onBg.copy(alpha = 0.5f), fontSize = 11.sp)
                }},
                navigationIcon = { IconButton(onClick = onBackClick) { Icon(Icons.Default.ArrowBack, null, tint = onBg) } },
                actions = { IconButton(onClick = viewModel::refresh) { Icon(Icons.Default.Refresh, null, tint = onBg) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = surface)
            )
        }
    ) { padding ->
        when {
            state.isLoading && state.sections.isEmpty() -> {
                Box(Modifier.fillMaxSize(), Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(color = primary)
                        Spacer(Modifier.height(16.dp))
                        Text(s.discoverLoading, color = onBg.copy(alpha = 0.5f), fontSize = 14.sp)
                    }
                }
            }
            state.error != null && state.sections.isEmpty() -> {
                Box(Modifier.fillMaxSize(), Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.WifiOff, null, tint = onBg.copy(alpha = 0.4f), modifier = Modifier.size(64.dp))
                        Spacer(Modifier.height(16.dp))
                        Text(s.noConnection, color = onBg, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                        Spacer(Modifier.height(20.dp))
                        Button(onClick = viewModel::refresh, colors = ButtonDefaults.buttonColors(containerColor = primary)) {
                            Text(s.retry, color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
            else -> {
                LazyColumn(modifier = Modifier.padding(padding), contentPadding = PaddingValues(bottom = 24.dp)) {
                    items(state.sections) { section ->
                        Column(modifier = Modifier.fillMaxWidth().padding(top = 20.dp)) {
                            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(section.title, color = onBg, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                Text("${section.games.size} игр", color = onBg.copy(alpha = 0.5f), fontSize = 12.sp)
                            }
                            LazyRow(contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                items(section.games, key = { "${section.title}_${it.id}" }) { game ->
                                    DiscoverCard(game = game, onClick = { onGameClick(game.id) })
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DiscoverCard(game: DiscoverGame, onClick: () -> Unit) {
    val surface = MaterialTheme.colorScheme.surface
    val onBg    = MaterialTheme.colorScheme.onBackground
    val primary = MaterialTheme.colorScheme.primary
    val green   = Color(0xFFA4D007)
    val red     = Color(0xFFEF5350)

    Card(modifier = Modifier.width(160.dp).clickable(onClick = onClick),
        shape = RoundedCornerShape(10.dp), colors = CardDefaults.cardColors(containerColor = surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column {
            Box(modifier = Modifier.fillMaxWidth().height(110.dp)) {
                AsyncImage(model = game.backgroundImage, contentDescription = game.name,
                    contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
                Box(modifier = Modifier.fillMaxWidth().height(50.dp).align(Alignment.BottomCenter)
                    .background(Brush.verticalGradient(listOf(Color.Transparent, surface))))
                game.metacritic?.let { mc ->
                    Box(modifier = Modifier.align(Alignment.TopStart).padding(6.dp)
                        .background(when { mc >= 75 -> green; mc >= 50 -> Color(0xFFFFB300); else -> red }, RoundedCornerShape(4.dp))
                        .padding(horizontal = 5.dp, vertical = 2.dp)) {
                        Text(mc.toString(), color = Color(0xFF0A0A0F), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
                val year = game.released?.take(4)?.toIntOrNull() ?: 0
                if (year >= 2024) {
                    Box(modifier = Modifier.align(Alignment.TopEnd).padding(6.dp)
                        .background(primary, RoundedCornerShape(4.dp)).padding(horizontal = 5.dp, vertical = 2.dp)) {
                        Text("NEW", color = MaterialTheme.colorScheme.onPrimary, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)) {
                Text(game.name, color = onBg, fontWeight = FontWeight.SemiBold, fontSize = 12.sp,
                    maxLines = 2, overflow = TextOverflow.Ellipsis, lineHeight = 16.sp)
                Spacer(Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text(game.genres.firstOrNull() ?: "", color = onBg.copy(alpha = 0.5f), fontSize = 10.sp, maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f))
                    if (game.rating > 0) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Star, null, tint = Color(0xFFFFD700), modifier = Modifier.size(11.dp))
                            Spacer(Modifier.width(2.dp))
                            Text(String.format("%.1f", game.rating), color = onBg, fontSize = 10.sp)
                        }
                    }
                }
                if (!game.released.isNullOrBlank()) {
                    Spacer(Modifier.height(2.dp))
                    Text(game.released, color = onBg.copy(alpha = 0.4f), fontSize = 10.sp)
                }
            }
        }
    }
}
