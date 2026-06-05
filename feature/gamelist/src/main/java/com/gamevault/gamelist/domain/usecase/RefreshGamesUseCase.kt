package com.gamevault.gamelist.domain.usecase

import com.gamevault.gamelist.domain.repository.GameListRepository
import javax.inject.Inject

class RefreshGamesUseCase @Inject constructor(
    private val repository: GameListRepository
) {
    suspend operator fun invoke(platform: String?) {
        repository.refreshGames(platform)
    }
}
