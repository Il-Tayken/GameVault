package com.gamevault.gamelist.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.gamevault.database.GameVaultDatabase
import com.gamevault.gamelist.data.mapper.toDomain
import com.gamevault.gamelist.data.mapper.toEntity
import com.gamevault.gamelist.domain.model.Game
import com.gamevault.gamelist.domain.repository.GameListRepository
import com.gamevault.network.api.RawgApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GameListRepositoryImpl @Inject constructor(
    private val apiService: RawgApiService,
    private val database: GameVaultDatabase
) : GameListRepository {

    override fun getGames(platform: String?): Flow<List<Game>> {
        return if (platform.isNullOrBlank()) {
            database.gameEntityQueries.selectAll()
                .asFlow().mapToList(Dispatchers.IO)
                .map { it.map { e -> e.toDomain() } }
        } else {
            database.gameEntityQueries.selectByPlatform(platform)
                .asFlow().mapToList(Dispatchers.IO)
                .map { it.map { e -> e.toDomain() } }
        }
    }

    override suspend fun refreshGames(platform: String?, useCache: Boolean) {
        // If caching disabled — clear non-favorites first
        if (!useCache) {
            try {
                val favIds = database.gameEntityQueries.selectAll()
                    .executeAsList()
                    .filter { it.isFavorite == 1L }
                    .map { it.id }
                database.gameEntityQueries.deleteAll()
                // We'll re-insert after fetching, favorites handled below
            } catch (_: Exception) {}
        }

        try {
            (1..3).forEach { page ->
                val response = apiService.getGames(
                    page = page,
                    pageSize = 40,
                    platforms = platform?.takeIf { it.isNotBlank() }
                )
                val queries = database.gameEntityQueries
                response.results.forEach { dto ->
                    val existing = try {
                        queries.selectById(dto.id.toLong()).executeAsOneOrNull()
                    } catch (_: Exception) { null }
                    val entity = dto.toEntity().copy(isFavorite = existing?.isFavorite ?: 0)
                    queries.insert(entity)
                }
            }
        } catch (_: Exception) {}
    }

    override suspend fun toggleFavorite(gameId: Int, isFavorite: Boolean) {
        database.gameEntityQueries.updateFavorite(
            isFavorite = if (isFavorite) 1L else 0L,
            id = gameId.toLong()
        )
    }

    override suspend fun clearCache() {
        try {
            // Keep favorites, remove the rest
            val allGames = database.gameEntityQueries.selectAll().executeAsList()
            database.gameEntityQueries.deleteAll()
            // Re-insert favorites only
            allGames.filter { it.isFavorite == 1L }.forEach { fav ->
                database.gameEntityQueries.insert(fav)
            }
        } catch (_: Exception) {}
    }

    override suspend fun getCacheSize(): Int = try {
        database.gameEntityQueries.selectAll().executeAsList().size
    } catch (_: Exception) { 0 }
}
