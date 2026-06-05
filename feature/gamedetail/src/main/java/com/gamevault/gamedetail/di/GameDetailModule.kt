package com.gamevault.gamedetail.di

import com.gamevault.gamedetail.data.repository.GameDetailRepositoryImpl
import com.gamevault.gamedetail.domain.repository.GameDetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GameDetailModule {

    @Binds
    @Singleton
    abstract fun bindGameDetailRepository(
        impl: GameDetailRepositoryImpl
    ): GameDetailRepository
}
