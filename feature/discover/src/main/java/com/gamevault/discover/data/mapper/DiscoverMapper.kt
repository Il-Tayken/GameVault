package com.gamevault.discover.data.mapper

import com.gamevault.discover.domain.model.DiscoverGame
import com.gamevault.network.model.GameDto

fun GameDto.toDiscoverGame(): DiscoverGame = DiscoverGame(
    id = this.id,
    name = this.name,
    backgroundImage = this.backgroundImage,
    rating = this.rating,
    metacritic = this.metacritic,
    released = this.released,
    platforms = this.platforms?.map { wrapper -> wrapper.platform.name } ?: emptyList(),
    genres = this.genres?.map { genre -> genre.name } ?: emptyList()
)
