package com.gamevault.gamedetail.domain.repository

import com.gamevault.gamedetail.domain.model.GameDetail
import kotlinx.coroutines.flow.Flow

interface GameDetailRepository {
    fun getGameDetail(gameId: Int): Flow<GameDetail?>
    suspend fun fetchGameDetail(gameId: Int)
    suspend fun toggleFavorite(gameId: Int, isFavorite: Boolean)
}
