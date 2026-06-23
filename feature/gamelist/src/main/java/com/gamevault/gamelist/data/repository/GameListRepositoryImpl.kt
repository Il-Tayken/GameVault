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
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
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

    override fun getGamesByStore(storeId: String): Flow<List<Game>> =
        database.gameEntityQueries.selectByStore(storeId)
            .asFlow().mapToList(Dispatchers.IO)
            .map { it.map { e -> e.toDomain() } }

    override fun getGamesBySource(source: String): Flow<List<Game>> =
        database.gameEntityQueries.selectBySource(source)
            .asFlow().mapToList(Dispatchers.IO)
            .map { it.map { e -> e.toDomain() } }

    // Загружает игры параллельно — быстрее и больше
    override suspend fun refreshGames(platform: String?, useCache: Boolean) {
        if (!useCache) {
            try { database.gameEntityQueries.deleteNonFavoritesBySource("rawg") }
            catch (_: Exception) {}
        }
        try {
            coroutineScope {
                // Загружаем 5 страниц параллельно = 200 игр
                val pages = (1..5).map { page ->
                    async(Dispatchers.IO) {
                        try {
                            apiService.getGames(
                                page = page,
                                pageSize = 40,
                                platforms = platform?.takeIf { it.isNotBlank() }
                            ).results
                        } catch (_: Exception) { emptyList() }
                    }
                }
                // Ещё дополнительные запросы с разной сортировкой
                val byMetacritic = async(Dispatchers.IO) {
                    try { apiService.getGames(page = 1, pageSize = 40, ordering = "-metacritic").results }
                    catch (_: Exception) { emptyList() }
                }
                val byReleased = async(Dispatchers.IO) {
                    try { apiService.getGames(page = 1, pageSize = 40, ordering = "-released").results }
                    catch (_: Exception) { emptyList() }
                }
                val byPlaytime = async(Dispatchers.IO) {
                    try { apiService.getGames(page = 1, pageSize = 40, ordering = "-playtime").results }
                    catch (_: Exception) { emptyList() }
                }

                val allResults = (pages.awaitAll().flatten() +
                        byMetacritic.await() +
                        byReleased.await() +
                        byPlaytime.await())
                    .distinctBy { it.id }

                saveGames(allResults.map { dto -> dto.toEntity("rawg") })
            }
        } catch (_: Exception) {}
    }

    override suspend fun refreshSteamGames() {
        try { database.gameEntityQueries.deleteNonFavoritesBySource("steam") }
        catch (_: Exception) {}

        val today = LocalDate.now()
        val oneYearAgo = today.minusYears(1).toString()
        val sixMonthsAgo = today.minusMonths(6).toString()

        try {
            coroutineScope {
                // Топ Steam — несколько страниц
                val topPages = (1..4).map { page ->
                    async(Dispatchers.IO) {
                        try { apiService.getTopSteam(pageSize = 40).results }
                        catch (_: Exception) { emptyList() }
                    }
                }
                // Новинки Steam за год
                val newSteam = async(Dispatchers.IO) {
                    try { apiService.getNewSteam(dates = "$oneYearAgo,$today", pageSize = 40).results }
                    catch (_: Exception) { emptyList() }
                }
                // Новинки за 6 месяцев
                val newSteam2 = async(Dispatchers.IO) {
                    try { apiService.getNewSteam(dates = "$sixMonthsAgo,$today", pageSize = 40).results }
                    catch (_: Exception) { emptyList() }
                }
                // Лучшие по рейтингу в Steam
                val bestSteam = async(Dispatchers.IO) {
                    try { apiService.getBestSteam(pageSize = 40).results }
                    catch (_: Exception) { emptyList() }
                }
                // Лучшие по Metacritic в Steam
                val metacriticSteam = async(Dispatchers.IO) {
                    try {
                        apiService.getGames(
                            pageSize = 40,
                            ordering = "-metacritic",
                            platforms = RawgApiService.PC_ID,
                            stores = RawgApiService.STEAM_STORE_ID
                        ).results
                    } catch (_: Exception) { emptyList() }
                }

                val allSteam = (topPages.awaitAll().flatten() +
                        newSteam.await() +
                        newSteam2.await() +
                        bestSteam.await() +
                        metacriticSteam.await())
                    .distinctBy { it.id }

                saveGames(allSteam.map { dto -> dto.toEntity("steam") })
            }
        } catch (_: Exception) {}
    }

    override suspend fun refreshEpicGames() {
        try { database.gameEntityQueries.deleteNonFavoritesBySource("epic") }
        catch (_: Exception) {}

        val today = LocalDate.now()
        val oneYearAgo = today.minusYears(1).toString()
        val sixMonthsAgo = today.minusMonths(6).toString()

        try {
            coroutineScope {
                val topEpic = async(Dispatchers.IO) {
                    try { apiService.getTopEpic(pageSize = 40).results }
                    catch (_: Exception) { emptyList() }
                }
                val newEpic = async(Dispatchers.IO) {
                    try { apiService.getNewEpic(dates = "$oneYearAgo,$today", pageSize = 40).results }
                    catch (_: Exception) { emptyList() }
                }
                val newEpic2 = async(Dispatchers.IO) {
                    try { apiService.getNewEpic(dates = "$sixMonthsAgo,$today", pageSize = 40).results }
                    catch (_: Exception) { emptyList() }
                }
                val bestEpic = async(Dispatchers.IO) {
                    try { apiService.getBestEpic(pageSize = 40).results }
                    catch (_: Exception) { emptyList() }
                }
                val metacriticEpic = async(Dispatchers.IO) {
                    try {
                        apiService.getGames(
                            pageSize = 40,
                            ordering = "-metacritic",
                            platforms = RawgApiService.PC_ID,
                            stores = RawgApiService.EPIC_STORE_ID
                        ).results
                    } catch (_: Exception) { emptyList() }
                }

                val allEpic = (topEpic.await() +
                        newEpic.await() +
                        newEpic2.await() +
                        bestEpic.await() +
                        metacriticEpic.await())
                    .distinctBy { it.id }

                saveGames(allEpic.map { dto -> dto.toEntity("epic") })
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
            val allGames = database.gameEntityQueries.selectAll().executeAsList()
            database.gameEntityQueries.deleteAll()
            allGames.filter { it.isFavorite == 1L }.forEach { fav ->
                database.gameEntityQueries.insert(fav)
            }
        } catch (_: Exception) {}
    }

    override suspend fun getCacheSize(): Int = try {
        database.gameEntityQueries.selectAll().executeAsList().size
    } catch (_: Exception) { 0 }

    private fun saveGames(entities: List<com.gamevault.database.GameEntity>) {
        val queries = database.gameEntityQueries
        entities.forEach { entity ->
            try {
                val existing = queries.selectById(entity.id).executeAsOneOrNull()
                val toSave = entity.copy(isFavorite = existing?.isFavorite ?: 0)
                queries.insert(toSave)
            } catch (_: Exception) {}
        }
    }
}
