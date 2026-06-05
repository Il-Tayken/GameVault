package com.gamevault.database

import kotlin.Double
import kotlin.Long
import kotlin.String

public data class GameEntity(
  public val id: Long,
  public val name: String,
  public val backgroundImage: String?,
  public val rating: Double,
  public val ratingTop: Long,
  public val released: String?,
  public val metacritic: Long?,
  public val playtime: Long,
  public val platforms: String,
  public val genres: String,
  public val shortScreenshots: String,
  public val isFavorite: Long,
)
