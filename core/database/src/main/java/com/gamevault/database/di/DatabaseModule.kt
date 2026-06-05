package com.gamevault.database.di

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.gamevault.database.GameVaultDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideGameVaultDatabase(@ApplicationContext context: Context): GameVaultDatabase {
        return GameVaultDatabase(
            AndroidSqliteDriver(GameVaultDatabase.Schema, context, "gamevault.db")
        )
    }
}
