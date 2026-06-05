package com.gamevault.gamelist.domain.model

data class Game(
    val id: Int,
    val name: String,
    val backgroundImage: String?,
    val rating: Double,
    val ratingTop: Int,
    val released: String?,
    val metacritic: Int?,
    val playtime: Int,
    val platforms: List<String>,
    val genres: List<String>,
    val isFavorite: Boolean,
    val esrbRating: String? = null   // e.g. "mature", "adults-only", "everyone"
)

enum class Platform(val displayName: String, val rawgId: String) {
    ALL("All Platforms", ""),
    PC("PC", "4"),
    PS5("PlayStation 5", "187"),
    PS4("PlayStation 4", "18"),
    XBOX_ONE("Xbox One", "1"),
    XBOX_SERIES("Xbox Series X", "186"),
    MOBILE("Mobile", "3,21"),
    NINTENDO("Nintendo Switch", "7")
}
