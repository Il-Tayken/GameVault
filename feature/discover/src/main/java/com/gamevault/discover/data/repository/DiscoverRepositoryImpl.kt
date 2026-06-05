package com.gamevault.discover.data.repository

import com.gamevault.discover.data.mapper.toDiscoverGame
import com.gamevault.discover.domain.model.DiscoverGame
import com.gamevault.discover.domain.repository.DiscoverRepository
import com.gamevault.network.api.RawgApiService
import java.time.LocalDate
import javax.inject.Inject

class DiscoverRepositoryImpl @Inject constructor(
    private val api: RawgApiService
) : DiscoverRepository {

    override suspend fun getPopular(): List<DiscoverGame> {
        return try {
            api.getPopular().results.map { dto -> dto.toDiscoverGame() }
        } catch (e: Exception) { emptyList() }
    }

    override suspend fun getNewReleases(): List<DiscoverGame> {
        return try {
            val today = LocalDate.now()
            val ago = today.minusMonths(3)
            api.getNewReleases(dates = "$ago,$today")
                .results
                .sortedByDescending { dto -> dto.released }
                .map { dto -> dto.toDiscoverGame() }
        } catch (e: Exception) { emptyList() }
    }

    override suspend fun getUpcoming(): List<DiscoverGame> {
        return try {
            val today = LocalDate.now()
            val soon = today.plusMonths(6)
            api.getUpcoming(dates = "$today,$soon")
                .results
                .sortedBy { dto -> dto.released }
                .map { dto -> dto.toDiscoverGame() }
        } catch (e: Exception) { emptyList() }
    }

    override suspend fun getNewOnPC(): List<DiscoverGame> {
        return try {
            val today = LocalDate.now()
            val ago = today.minusMonths(6)
            api.getNewOnPC(dates = "$ago,$today")
                .results
                .sortedByDescending { dto -> dto.released }
                .map { dto -> dto.toDiscoverGame() }
        } catch (e: Exception) { emptyList() }
    }

    override suspend fun getTopOnSteam(): List<DiscoverGame> {
        return try {
            api.getTopSteam().results.map { dto -> dto.toDiscoverGame() }
        } catch (e: Exception) { emptyList() }
    }

    override suspend fun getTopOnEpic(): List<DiscoverGame> {
        return try {
            api.getTopEpic().results.map { dto -> dto.toDiscoverGame() }
        } catch (e: Exception) { emptyList() }
    }

    override suspend fun getTopOnPS(): List<DiscoverGame> {
        return try {
            val platforms = "${RawgApiService.PS5_ID},${RawgApiService.PS4_ID}"
            api.getTopByPlatform(platforms = platforms).results.map { dto -> dto.toDiscoverGame() }
        } catch (e: Exception) { emptyList() }
    }

    override suspend fun getTopOnXbox(): List<DiscoverGame> {
        return try {
            val platforms = "${RawgApiService.XBOX_SERIES_ID},${RawgApiService.XBOX_ONE_ID}"
            api.getTopByPlatform(platforms = platforms).results.map { dto -> dto.toDiscoverGame() }
        } catch (e: Exception) { emptyList() }
    }
}
