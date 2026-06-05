package com.gamevault.database

import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Double
import kotlin.Long
import kotlin.String

public class GameEntityQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun <T : Any> selectAll(mapper: (
    id: Long,
    name: String,
    backgroundImage: String?,
    rating: Double,
    ratingTop: Long,
    released: String?,
    metacritic: Long?,
    playtime: Long,
    platforms: String,
    genres: String,
    shortScreenshots: String,
    isFavorite: Long,
  ) -> T): Query<T> = Query(-2_011_533_346, arrayOf("GameEntity"), driver, "GameEntity.sq",
      "selectAll",
      "SELECT GameEntity.id, GameEntity.name, GameEntity.backgroundImage, GameEntity.rating, GameEntity.ratingTop, GameEntity.released, GameEntity.metacritic, GameEntity.playtime, GameEntity.platforms, GameEntity.genres, GameEntity.shortScreenshots, GameEntity.isFavorite FROM GameEntity ORDER BY isFavorite DESC, rating DESC") {
      cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getDouble(3)!!,
      cursor.getLong(4)!!,
      cursor.getString(5),
      cursor.getLong(6),
      cursor.getLong(7)!!,
      cursor.getString(8)!!,
      cursor.getString(9)!!,
      cursor.getString(10)!!,
      cursor.getLong(11)!!
    )
  }

  public fun selectAll(): Query<GameEntity> = selectAll { id, name, backgroundImage, rating,
      ratingTop, released, metacritic, playtime, platforms, genres, shortScreenshots, isFavorite ->
    GameEntity(
      id,
      name,
      backgroundImage,
      rating,
      ratingTop,
      released,
      metacritic,
      playtime,
      platforms,
      genres,
      shortScreenshots,
      isFavorite
    )
  }

  public fun <T : Any> selectByPlatform(platform: String, mapper: (
    id: Long,
    name: String,
    backgroundImage: String?,
    rating: Double,
    ratingTop: Long,
    released: String?,
    metacritic: Long?,
    playtime: Long,
    platforms: String,
    genres: String,
    shortScreenshots: String,
    isFavorite: Long,
  ) -> T): Query<T> = SelectByPlatformQuery(platform) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getDouble(3)!!,
      cursor.getLong(4)!!,
      cursor.getString(5),
      cursor.getLong(6),
      cursor.getLong(7)!!,
      cursor.getString(8)!!,
      cursor.getString(9)!!,
      cursor.getString(10)!!,
      cursor.getLong(11)!!
    )
  }

  public fun selectByPlatform(platform: String): Query<GameEntity> = selectByPlatform(platform) {
      id, name, backgroundImage, rating, ratingTop, released, metacritic, playtime, platforms,
      genres, shortScreenshots, isFavorite ->
    GameEntity(
      id,
      name,
      backgroundImage,
      rating,
      ratingTop,
      released,
      metacritic,
      playtime,
      platforms,
      genres,
      shortScreenshots,
      isFavorite
    )
  }

  public fun <T : Any> selectById(id: Long, mapper: (
    id: Long,
    name: String,
    backgroundImage: String?,
    rating: Double,
    ratingTop: Long,
    released: String?,
    metacritic: Long?,
    playtime: Long,
    platforms: String,
    genres: String,
    shortScreenshots: String,
    isFavorite: Long,
  ) -> T): Query<T> = SelectByIdQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getString(2),
      cursor.getDouble(3)!!,
      cursor.getLong(4)!!,
      cursor.getString(5),
      cursor.getLong(6),
      cursor.getLong(7)!!,
      cursor.getString(8)!!,
      cursor.getString(9)!!,
      cursor.getString(10)!!,
      cursor.getLong(11)!!
    )
  }

  public fun selectById(id: Long): Query<GameEntity> = selectById(id) { id_, name, backgroundImage,
      rating, ratingTop, released, metacritic, playtime, platforms, genres, shortScreenshots,
      isFavorite ->
    GameEntity(
      id_,
      name,
      backgroundImage,
      rating,
      ratingTop,
      released,
      metacritic,
      playtime,
      platforms,
      genres,
      shortScreenshots,
      isFavorite
    )
  }

  public fun insert(GameEntity: GameEntity) {
    driver.execute(443_876_480,
        """INSERT OR REPLACE INTO GameEntity (id, name, backgroundImage, rating, ratingTop, released, metacritic, playtime, platforms, genres, shortScreenshots, isFavorite) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""",
        12) {
          bindLong(0, GameEntity.id)
          bindString(1, GameEntity.name)
          bindString(2, GameEntity.backgroundImage)
          bindDouble(3, GameEntity.rating)
          bindLong(4, GameEntity.ratingTop)
          bindString(5, GameEntity.released)
          bindLong(6, GameEntity.metacritic)
          bindLong(7, GameEntity.playtime)
          bindString(8, GameEntity.platforms)
          bindString(9, GameEntity.genres)
          bindString(10, GameEntity.shortScreenshots)
          bindLong(11, GameEntity.isFavorite)
        }
    notifyQueries(443_876_480) { emit ->
      emit("GameEntity")
    }
  }

  public fun updateFavorite(isFavorite: Long, id: Long) {
    driver.execute(820_320_332, """UPDATE GameEntity SET isFavorite = ? WHERE id = ?""", 2) {
          bindLong(0, isFavorite)
          bindLong(1, id)
        }
    notifyQueries(820_320_332) { emit ->
      emit("GameEntity")
    }
  }

  public fun deleteAll() {
    driver.execute(-654_267_185, """DELETE FROM GameEntity""", 0)
    notifyQueries(-654_267_185) { emit ->
      emit("GameEntity")
    }
  }

  private inner class SelectByPlatformQuery<out T : Any>(
    public val platform: String,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("GameEntity", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("GameEntity", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(-625_242_867,
        """SELECT GameEntity.id, GameEntity.name, GameEntity.backgroundImage, GameEntity.rating, GameEntity.ratingTop, GameEntity.released, GameEntity.metacritic, GameEntity.playtime, GameEntity.platforms, GameEntity.genres, GameEntity.shortScreenshots, GameEntity.isFavorite FROM GameEntity WHERE platforms LIKE '%' || ? || '%' ORDER BY isFavorite DESC, rating DESC""",
        mapper, 1) {
      bindString(0, platform)
    }

    override fun toString(): String = "GameEntity.sq:selectByPlatform"
  }

  private inner class SelectByIdQuery<out T : Any>(
    public val id: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("GameEntity", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("GameEntity", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(2_067_017_013,
        """SELECT GameEntity.id, GameEntity.name, GameEntity.backgroundImage, GameEntity.rating, GameEntity.ratingTop, GameEntity.released, GameEntity.metacritic, GameEntity.playtime, GameEntity.platforms, GameEntity.genres, GameEntity.shortScreenshots, GameEntity.isFavorite FROM GameEntity WHERE id = ?""",
        mapper, 1) {
      bindLong(0, id)
    }

    override fun toString(): String = "GameEntity.sq:selectById"
  }
}
