package com.gamevault.database

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import com.gamevault.database.database.newInstance
import com.gamevault.database.database.schema
import kotlin.Unit

public interface GameVaultDatabase : Transacter {
  public val gameEntityQueries: GameEntityQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = GameVaultDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): GameVaultDatabase =
        GameVaultDatabase::class.newInstance(driver)
  }
}
