package com.gamevault.gamedetail.domain.usecase

import com.gamevault.gamedetail.domain.model.GameDetail
import com.gamevault.gamedetail.domain.repository.GameDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGameDetailUseCase @Inject constructor(
    private val repository: GameDetailRepository
) {
    operator fun invoke(gameId: Int): Flow<GameDetail?> = repository.getGameDetail(gameId)
}

class FetchGameDetailUseCase @Inject constructor(
    private val repository: GameDetailRepository
) {
    suspend operator fun invoke(gameId: Int) = repository.fetchGameDetail(gameId)
}

class ToggleDetailFavoriteUseCase @Inject constructor(
    private val repository: GameDetailRepository
) {
    suspend operator fun invoke(gameId: Int, isFavorite: Boolean) =
        repository.toggleFavorite(gameId, isFavorite)
}
