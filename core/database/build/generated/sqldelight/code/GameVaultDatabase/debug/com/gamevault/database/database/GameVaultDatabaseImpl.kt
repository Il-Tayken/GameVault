package com.gamevault.database.database

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.AfterVersion
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import com.gamevault.database.GameEntityQueries
import com.gamevault.database.GameVaultDatabase
import kotlin.Long
import kotlin.Unit
import kotlin.reflect.KClass

internal val KClass<GameVaultDatabase>.schema: SqlSchema<QueryResult.Value<Unit>>
  get() = GameVaultDatabaseImpl.Schema

internal fun KClass<GameVaultDatabase>.newInstance(driver: SqlDriver): GameVaultDatabase =
    GameVaultDatabaseImpl(driver)

private class GameVaultDatabaseImpl(
  driver: SqlDriver,
) : TransacterImpl(driver), GameVaultDatabase {
  override val gameEntityQueries: GameEntityQueries = GameEntityQueries(driver)

  public object Schema : SqlSchema<QueryResult.Value<Unit>> {
    override val version: Long
      get() = 1

    override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
      driver.execute(null, """
          |CREATE TABLE GameEntity (
          |    id INTEGER NOT NULL PRIMARY KEY,
          |    name TEXT NOT NULL,
          |    backgroundImage TEXT,
          |    rating REAL NOT NULL DEFAULT 0.0,
          |    ratingTop INTEGER NOT NULL DEFAULT 0,
          |    released TEXT,
          |    metacritic INTEGER,
          |    playtime INTEGER NOT NULL DEFAULT 0,
          |    platforms TEXT NOT NULL DEFAULT '',
          |    genres TEXT NOT NULL DEFAULT '',
          |    shortScreenshots TEXT NOT NULL DEFAULT '',
          |    isFavorite INTEGER NOT NULL DEFAULT 0
          |)
          """.trimMargin(), 0)
      return QueryResult.Unit
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Long,
      newVersion: Long,
      vararg callbacks: AfterVersion,
    ): QueryResult.Value<Unit> = QueryResult.Unit
  }
}
