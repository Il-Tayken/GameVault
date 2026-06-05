package com.gamevault.gamelist.domain.usecase

import com.gamevault.gamelist.domain.repository.GameListRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: GameListRepository
) {
    suspend operator fun invoke(gameId: Int, isFavorite: Boolean) {
        repository.toggleFavorite(gameId, isFavorite)
    }
}
