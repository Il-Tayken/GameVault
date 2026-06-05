package com.gamevault.gamelist.domain.usecase

import com.gamevault.gamelist.domain.model.Game
import com.gamevault.gamelist.domain.repository.GameListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: GameListRepository
) {
    operator fun invoke(platform: String?): Flow<List<Game>> {
        return repository.getGames(platform)
    }
}
