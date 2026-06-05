package com.gamevault.gamelist.domain.repository

import com.gamevault.gamelist.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameListRepository {
    fun getGames(platform: String?): Flow<List<Game>>
    suspend fun refreshGames(platform: String?, useCache: Boolean = true)
    suspend fun toggleFavorite(gameId: Int, isFavorite: Boolean)
    suspend fun clearCache()
    suspend fun getCacheSize(): Int
}
