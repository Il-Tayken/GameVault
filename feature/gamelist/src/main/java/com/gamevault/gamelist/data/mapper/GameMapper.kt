package com.gamevault.gamelist.data.mapper

import com.gamevault.database.GameEntity
import com.gamevault.gamelist.domain.model.Game
import com.gamevault.network.model.GameDto

fun GameDto.toEntity(source: String = "rawg"): GameEntity {
    val dto = this
    val esrbPrefix = dto.esrbRating?.slug?.let { "esrb:$it|" } ?: ""
    val screenshotsStr = esrbPrefix + (dto.shortScreenshots?.joinToString(",") { it.image } ?: "")
    val storeIdsStr = dto.stores?.joinToString(",") { it.store.id.toString() } ?: ""

    return GameEntity(
        id = dto.id.toLong(),
        name = dto.name,
        backgroundImage = dto.backgroundImage,
        rating = dto.rating,
        ratingTop = dto.ratingTop.toLong(),
        released = dto.released,
        metacritic = dto.metacritic?.toLong(),
        playtime = dto.playtime.toLong(),
        platforms = dto.platforms?.joinToString(",") { it.platform.name } ?: "",
        genres = dto.genres?.joinToString(",") { it.name } ?: "",
        shortScreenshots = screenshotsStr,
        isFavorite = 0,
        storeIds = storeIdsStr,
        source = source
    )
}

fun GameEntity.toDomain(): Game {
    val esrb = if (this.shortScreenshots.startsWith("esrb:")) {
        this.shortScreenshots.substringAfter("esrb:").substringBefore("|")
    } else null

    return Game(
        id = this.id.toInt(),
        name = this.name,
        backgroundImage = this.backgroundImage,
        rating = this.rating,
        ratingTop = this.ratingTop.toInt(),
        released = this.released,
        metacritic = this.metacritic?.toInt(),
        playtime = this.playtime.toInt(),
        platforms = if (this.platforms.isBlank()) emptyList() else this.platforms.split(","),
        genres = if (this.genres.isBlank()) emptyList() else this.genres.split(","),
        isFavorite = this.isFavorite == 1L,
        esrbRating = esrb,
        storeIds = if (this.storeIds.isBlank()) emptyList() else this.storeIds.split(","),
        source = this.source
    )
}
