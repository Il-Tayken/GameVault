package com.gamevault.gamedetail.data.mapper

import com.gamevault.database.GameEntity
import com.gamevault.gamedetail.domain.model.GameDetail
import com.gamevault.network.model.GameDetailDto

fun GameDetailDto.toEntity(isFavorite: Long = 0): GameEntity = GameEntity(
    id = this.id.toLong(),
    name = this.name,
    backgroundImage = this.backgroundImage,
    rating = this.rating,
    ratingTop = this.ratingTop.toLong(),
    released = this.released,
    metacritic = this.metacritic?.toLong(),
    playtime = this.playtime.toLong(),
    platforms = this.platforms?.joinToString(",") { it.platform.name } ?: "",
    genres = this.genres?.joinToString(",") { it.name } ?: "",
    shortScreenshots = this.backgroundImageAdditional ?: "",
    isFavorite = isFavorite
)

fun GameEntity.toDetailDomain(): GameDetail = GameDetail(
    id = this.id.toInt(),
    name = this.name,
    backgroundImage = this.backgroundImage,
    backgroundImageAdditional = this.shortScreenshots.takeIf { it.isNotBlank() },
    rating = this.rating,
    ratingTop = this.ratingTop.toInt(),
    released = this.released,
    metacritic = this.metacritic?.toInt(),
    playtime = this.playtime.toInt(),
    descriptionRaw = null,
    platforms = if (this.platforms.isBlank()) emptyList() else this.platforms.split(","),
    genres = if (this.genres.isBlank()) emptyList() else this.genres.split(","),
    developers = emptyList(),
    publishers = emptyList(),
    website = null,
    isFavorite = this.isFavorite == 1L
)

fun GameDetailDto.toDomain(isFavorite: Boolean = false): GameDetail = GameDetail(
    id = this.id,
    name = this.name,
    backgroundImage = this.backgroundImage,
    backgroundImageAdditional = this.backgroundImageAdditional,
    rating = this.rating,
    ratingTop = this.ratingTop,
    released = this.released,
    metacritic = this.metacritic,
    playtime = this.playtime,
    descriptionRaw = this.descriptionRaw,
    platforms = this.platforms?.map { it.platform.name } ?: emptyList(),
    genres = this.genres?.map { it.name } ?: emptyList(),
    developers = this.developers?.map { it.name } ?: emptyList(),
    publishers = this.publishers?.map { it.name } ?: emptyList(),
    website = this.website,
    isFavorite = isFavorite
)
