package com.gamevault.gamedetail.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToOneOrNull
import com.gamevault.database.GameVaultDatabase
import com.gamevault.gamedetail.data.mapper.toDetailDomain
import com.gamevault.gamedetail.data.mapper.toEntity
import com.gamevault.gamedetail.domain.model.GameDetail
import com.gamevault.gamedetail.domain.repository.GameDetailRepository
import com.gamevault.network.api.RawgApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameDetailRepositoryImpl @Inject constructor(
    private val apiService: RawgApiService,
    private val database: GameVaultDatabase
) : GameDetailRepository {

    override fun getGameDetail(gameId: Int): Flow<GameDetail?> {
        return database.gameEntityQueries.selectById(gameId.toLong())
            .asFlow()
            .mapToOneOrNull(Dispatchers.IO)
            .map { it?.toDetailDomain() }
    }

    override suspend fun fetchGameDetail(gameId: Int) {
        try {
            val dto = apiService.getGameDetail(gameId)
            val existing = database.gameEntityQueries.selectById(gameId.toLong()).executeAsOneOrNull()
            val entity = dto.toEntity(isFavorite = existing?.isFavorite ?: 0)
            database.gameEntityQueries.insert(entity)
        } catch (e: Exception) {
            // use cached data
        }
    }

    override suspend fun toggleFavorite(gameId: Int, isFavorite: Boolean) {
        database.gameEntityQueries.updateFavorite(
            isFavorite = if (isFavorite) 1L else 0L,
            id = gameId.toLong()
        )
    }
}
