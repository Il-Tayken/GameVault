package com.gamevault.discover.domain.model

data class DiscoverGame(
    val id: Int,
    val name: String,
    val backgroundImage: String?,
    val rating: Double,
    val metacritic: Int?,
    val released: String?,
    val platforms: List<String>,
    val genres: List<String>
)

data class DiscoverSection(
    val title: String,
    val icon: String,
    val games: List<DiscoverGame>
)
