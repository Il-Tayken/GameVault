package com.gamevault.gamelist.data.mapper

import com.gamevault.database.GameEntity
import com.gamevault.gamelist.domain.model.Game
import com.gamevault.network.model.GameDto

fun GameDto.toEntity(): GameEntity {
    val dto = this
    val screenshotsStr = buildString {
        dto.esrbRating?.slug?.let { slug -> append("esrb:$slug|") }
        append(dto.shortScreenshots?.joinToString(",") { screenshot -> screenshot.image } ?: "")
    }
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
        isFavorite = 0
    )
}

fun GameEntity.toDomain(): Game {
    // Parse esrb from shortScreenshots prefix if present
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
        esrbRating = esrb
    )
}
