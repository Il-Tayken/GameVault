package com.gamevault.app.navigation

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object GameList : Screen("game_list/{username}") {
        fun createRoute(username: String) = "game_list/$username"
    }
    object GameDetail : Screen("game_detail/{gameId}") {
        fun createRoute(gameId: Int) = "game_detail/$gameId"
    }
    object Settings : Screen("settings/{username}") {
        fun createRoute(username: String) = "settings/$username"
    }
    object Discover : Screen("discover/{username}") {
        fun createRoute(username: String) = "discover/$username"
    }
}
