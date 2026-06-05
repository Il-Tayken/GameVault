package com.gamevault.gamedetail.presentation

import com.gamevault.common.AppStrings
import com.gamevault.common.getStrings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.gamevault.gamedetail.domain.model.GameDetail

val SteamDark = Color(0xFF171A21)
val SteamCard = Color(0xFF1E2328)
val SteamBlue = Color(0xFF1B2838)
val SteamAccent = Color(0xFF66C0F4)
val SteamGreenLight = Color(0xFFA4D007)
val SteamText = Color(0xFFC7D5E0)
val SteamSubText = Color(0xFF8F98A0)
val FavoriteRed = Color(0xFFEF5350)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(
    gameId: Int,
    onBackClick: () -> Unit,
    language: String = "Русский 🇷🇺",
    viewModel: GameDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val s = getStrings(language)
    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = SteamDark
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            if (uiState.isLoading && uiState.gameDetail == null) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = SteamAccent
                )
            } else {
                uiState.gameDetail?.let { game ->
                    Column(modifier = Modifier.verticalScroll(scrollState)) {
                        // Hero image
                        Box(modifier = Modifier.fillMaxWidth().height(280.dp)) {
                            AsyncImage(
                                model = game.backgroundImage,
                                contentDescription = game.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                            // Bottom gradient
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .align(Alignment.BottomCenter)
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(Color.Transparent, SteamDark)
                                        )
                                    )
                            )
                            // Back button
                            IconButton(
                                onClick = onBackClick,
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Icon(
                                    Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }
                        }

                        // Content card
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(SteamDark)
                                .padding(horizontal = 16.dp)
                        ) {
                            // Title row
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = game.name,
                                    color = SteamText,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.weight(1f),
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                IconButton(onClick = viewModel::onToggleFavorite) {
                                    Icon(
                                        imageVector = if (game.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                        contentDescription = "Favorite",
                                        tint = if (game.isFavorite) FavoriteRed else SteamSubText,
                                        modifier = Modifier.size(28.dp)
                                    )
                                }
                            }

                            Spacer(Modifier.height(8.dp))

                            // Genres chips
                            if (game.genres.isNotEmpty()) {
                                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    game.genres.take(3).forEach { genre ->
                                        Surface(
                                            shape = RoundedCornerShape(4.dp),
                                            color = SteamBlue
                                        ) {
                                            Text(
                                                text = genre,
                                                color = SteamAccent,
                                                fontSize = 11.sp,
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                            )
                                        }
                                    }
                                }
                                Spacer(Modifier.height(12.dp))
                            }

                            // Stats row
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(containerColor = SteamCard),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    horizontalArrangement = Arrangement.SpaceAround
                                ) {
                                    StatItem(label = s.rating, value = String.format("%.1f", game.rating), icon = "⭐")
                                    StatDivider()
                                    StatItem(label = s.metacritic, value = game.metacritic?.toString() ?: s.na, icon = "🎯")
                                    StatDivider()
                                    StatItem(label = s.playtime, value = "${game.playtime}h", icon = "🎮")
                                    StatDivider()
                                    StatItem(label = s.released, value = game.released?.take(4) ?: s.tba, icon = "📅")
                                }
                            }

                            Spacer(Modifier.height(16.dp))

                            // Description
                            if (!game.descriptionRaw.isNullOrBlank()) {
                                Text(
                                    text = s.aboutGame,
                                    color = SteamText,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(Modifier.height(8.dp))
                                Text(
                                    text = game.descriptionRaw.take(600).let {
                                        if (game.descriptionRaw.length > 600) "$it..." else it
                                    },
                                    color = SteamSubText,
                                    fontSize = 13.sp,
                                    lineHeight = 20.sp
                                )
                                Spacer(Modifier.height(16.dp))
                            }

                            // Platforms
                            if (game.platforms.isNotEmpty()) {
                                InfoSection(title = s.platforms, items = game.platforms)
                                Spacer(Modifier.height(12.dp))
                            }

                            // Developers
                            if (game.developers.isNotEmpty()) {
                                InfoSection(title = s.developers, items = game.developers)
                                Spacer(Modifier.height(12.dp))
                            }

                            // Publishers
                            if (game.publishers.isNotEmpty()) {
                                InfoSection(title = s.publishers, items = game.publishers)
                                Spacer(Modifier.height(24.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StatItem(label: String, value: String, icon: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = icon, fontSize = 18.sp)
        Spacer(Modifier.height(4.dp))
        Text(text = value, color = SteamText, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Text(text = label, color = SteamSubText, fontSize = 10.sp)
    }
}

@Composable
fun StatDivider() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(40.dp)
            .background(SteamSubText.copy(alpha = 0.3f))
    )
}

@Composable
fun InfoSection(title: String, items: List<String>) {
    Text(text = title, color = SteamText, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
    Spacer(Modifier.height(6.dp))
    Text(
        text = items.joinToString(", "),
        color = SteamSubText,
        fontSize = 13.sp
    )
}
