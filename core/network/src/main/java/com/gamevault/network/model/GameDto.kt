package com.gamevault.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GamesResponse(
    val count: Int = 0,
    val results: List<GameDto> = emptyList()
)

@Serializable
data class EsrbRatingDto(
    val id: Int = 0,
    val name: String = "",
    val slug: String = ""
)

@Serializable
data class GameDto(
    val id: Int,
    val name: String,
    @SerialName("background_image") val backgroundImage: String? = null,
    val rating: Double = 0.0,
    @SerialName("rating_top") val ratingTop: Int = 0,
    val released: String? = null,
    val metacritic: Int? = null,
    val playtime: Int = 0,
    val platforms: List<PlatformWrapper>? = null,
    val genres: List<GenreDto>? = null,
    @SerialName("short_screenshots") val shortScreenshots: List<ScreenshotDto>? = null,
    @SerialName("esrb_rating") val esrbRating: EsrbRatingDto? = null
)

@Serializable
data class PlatformWrapper(
    val platform: PlatformDto
)

@Serializable
data class PlatformDto(
    val id: Int,
    val name: String,
    val slug: String
)

@Serializable
data class GenreDto(
    val id: Int,
    val name: String,
    val slug: String
)

@Serializable
data class ScreenshotDto(
    val id: Int,
    val image: String
)

@Serializable
data class GameDetailDto(
    val id: Int,
    val name: String,
    @SerialName("background_image") val backgroundImage: String? = null,
    @SerialName("background_image_additional") val backgroundImageAdditional: String? = null,
    val rating: Double = 0.0,
    @SerialName("rating_top") val ratingTop: Int = 0,
    val released: String? = null,
    val metacritic: Int? = null,
    val playtime: Int = 0,
    val description: String? = null,
    @SerialName("description_raw") val descriptionRaw: String? = null,
    val platforms: List<PlatformWrapper>? = null,
    val genres: List<GenreDto>? = null,
    val developers: List<DeveloperDto>? = null,
    val publishers: List<PublisherDto>? = null,
    val website: String? = null
)

@Serializable
data class DeveloperDto(
    val id: Int,
    val name: String
)

@Serializable
data class PublisherDto(
    val id: Int,
    val name: String
)
