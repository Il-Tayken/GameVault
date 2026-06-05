package com.gamevault.discover.domain.repository

import com.gamevault.discover.domain.model.DiscoverGame

interface DiscoverRepository {
    suspend fun getPopular(): List<DiscoverGame>
    suspend fun getNewReleases(): List<DiscoverGame>
    suspend fun getUpcoming(): List<DiscoverGame>
    suspend fun getNewOnPC(): List<DiscoverGame>
    suspend fun getTopOnSteam(): List<DiscoverGame>
    suspend fun getTopOnEpic(): List<DiscoverGame>
    suspend fun getTopOnPS(): List<DiscoverGame>
    suspend fun getTopOnXbox(): List<DiscoverGame>
}
