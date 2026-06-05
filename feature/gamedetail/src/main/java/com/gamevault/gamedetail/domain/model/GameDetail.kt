package com.gamevault.gamedetail.domain.model

data class GameDetail(
    val id: Int,
    val name: String,
    val backgroundImage: String?,
    val backgroundImageAdditional: String?,
    val rating: Double,
    val ratingTop: Int,
    val released: String?,
    val metacritic: Int?,
    val playtime: Int,
    val descriptionRaw: String?,
    val platforms: List<String>,
    val genres: List<String>,
    val developers: List<String>,
    val publishers: List<String>,
    val website: String?,
    val isFavorite: Boolean
)
