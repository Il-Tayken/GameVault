package com.gamevault.network.api

import com.gamevault.network.model.GameDetailDto
import com.gamevault.network.model.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RawgApiService {

    @GET("games")
    suspend fun getGames(
        @Query("key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 40,
        @Query("ordering") ordering: String = "-rating",
        @Query("platforms") platforms: String? = null
    ): GamesResponse

    @GET("games")
    suspend fun getPopular(
        @Query("key") apiKey: String = API_KEY,
        @Query("page_size") pageSize: Int = 20,
        @Query("ordering") ordering: String = "-added",
        @Query("metacritic") metacritic: String = "80,100"
    ): GamesResponse

    @GET("games")
    suspend fun getNewReleases(
        @Query("key") apiKey: String = API_KEY,
        @Query("page_size") pageSize: Int = 20,
        @Query("ordering") ordering: String = "-released",
        @Query("dates") dates: String,
        @Query("platforms") platforms: String = "4,187,18,1,186,7"
    ): GamesResponse

    @GET("games")
    suspend fun getUpcoming(
        @Query("key") apiKey: String = API_KEY,
        @Query("page_size") pageSize: Int = 20,
        @Query("ordering") ordering: String = "released",
        @Query("dates") dates: String,
        @Query("platforms") platforms: String = "4,187,18,1,186,7"
    ): GamesResponse

    @GET("games")
    suspend fun getTopByPlatform(
        @Query("key") apiKey: String = API_KEY,
        @Query("page_size") pageSize: Int = 20,
        @Query("ordering") ordering: String = "-rating",
        @Query("platforms") platforms: String,
        @Query("metacritic") metacritic: String = "70,100"
    ): GamesResponse

    @GET("games")
    suspend fun getNewOnPC(
        @Query("key") apiKey: String = API_KEY,
        @Query("page_size") pageSize: Int = 20,
        @Query("ordering") ordering: String = "-released",
        @Query("dates") dates: String,
        @Query("platforms") platforms: String = PC_ID,
        @Query("stores") stores: String = "$STEAM_STORE_ID,$EPIC_STORE_ID"
    ): GamesResponse

    @GET("games")
    suspend fun getTopSteam(
        @Query("key") apiKey: String = API_KEY,
        @Query("page_size") pageSize: Int = 20,
        @Query("ordering") ordering: String = "-added",
        @Query("platforms") platforms: String = PC_ID,
        @Query("stores") stores: String = STEAM_STORE_ID
    ): GamesResponse

    @GET("games")
    suspend fun getTopEpic(
        @Query("key") apiKey: String = API_KEY,
        @Query("page_size") pageSize: Int = 20,
        @Query("ordering") ordering: String = "-added",
        @Query("platforms") platforms: String = PC_ID,
        @Query("stores") stores: String = EPIC_STORE_ID
    ): GamesResponse

    @GET("games/{id}")
    suspend fun getGameDetail(
        @Path("id") id: Int,
        @Query("key") apiKey: String = API_KEY
    ): GameDetailDto

    companion object {
        const val API_KEY = "b30e7b08165a4f7c8f838bbc6740d585"
        const val BASE_URL = "https://api.rawg.io/api/"

        const val PC_ID          = "4"
        const val PS5_ID         = "187"
        const val PS4_ID         = "18"
        const val XBOX_ONE_ID    = "1"
        const val XBOX_SERIES_ID = "186"
        const val NINTENDO_ID    = "7"

        const val STEAM_STORE_ID = "1"
        const val EPIC_STORE_ID  = "11"
        const val PS_STORE_ID    = "3"
        const val XBOX_STORE_ID  = "2"
    }
}
