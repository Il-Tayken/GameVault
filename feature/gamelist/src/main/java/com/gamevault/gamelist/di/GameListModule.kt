package com.gamevault.gamelist.di

import com.gamevault.gamelist.data.repository.GameListRepositoryImpl
import com.gamevault.gamelist.domain.repository.GameListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GameListModule {

    @Binds
    @Singleton
    abstract fun bindGameListRepository(
        impl: GameListRepositoryImpl
    ): GameListRepository
}
