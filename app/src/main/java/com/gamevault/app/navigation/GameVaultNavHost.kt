package com.gamevault.app.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gamevault.auth.presentation.AuthScreen
import com.gamevault.common.AppPrefs
import com.gamevault.discover.presentation.DiscoverScreen
import com.gamevault.gamedetail.presentation.GameDetailScreen
import com.gamevault.gamelist.presentation.GameListScreen
import com.gamevault.settings.presentation.SettingsScreen

@Composable
fun GameVaultNavHost() {
    val navController = rememberNavController()
    var sharedPrefs    by remember { mutableStateOf(AppPrefs()) }
    var clearCacheAction by remember { mutableStateOf<(() -> Unit)?>(null) }
    val lang = sharedPrefs.language

    NavHost(navController = navController, startDestination = Screen.Auth.route) {

        composable(Screen.Auth.route) {
            AuthScreen(onAuthSuccess = { username ->
                navController.navigate(Screen.GameList.createRoute(username)) {
                    popUpTo(Screen.Auth.route) { inclusive = true }
                }
            })
        }

        composable(
            route = Screen.GameList.route,
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { back ->
            val username = back.arguments?.getString("username") ?: "Игрок"
            // Read updated cache size from savedStateHandle
            val updatedCacheSize by back.savedStateHandle
                .getStateFlow("cacheSize", 0).collectAsState()

            GameListScreen(
                externalPrefs   = sharedPrefs,
                onGameClick     = { navController.navigate(Screen.GameDetail.createRoute(it)) },
                onSettingsClick = { prefs ->
                    sharedPrefs = prefs
                    navController.navigate(Screen.Settings.createRoute(username))
                },
                onDiscoverClick = { navController.navigate(Screen.Discover.createRoute(username)) },
                onClearCacheRequest = { action -> clearCacheAction = action }
            )
        }

        composable(
            route = Screen.GameDetail.route,
            arguments = listOf(navArgument("gameId") { type = NavType.IntType })
        ) { back ->
            val gameId = back.arguments?.getInt("gameId") ?: return@composable
            GameDetailScreen(
                gameId      = gameId,
                language    = lang,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.Settings.route,
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { back ->
            val username = back.arguments?.getString("username") ?: "Игрок"
            SettingsScreen(
                username     = username,
                initialPrefs = sharedPrefs,
                onBackClick  = { navController.popBackStack() },
                onApply      = { updated -> sharedPrefs = updated },
                onClearCache = { clearCacheAction?.invoke() },
                onLogout     = {
                    navController.navigate(Screen.Auth.route) { popUpTo(0) { inclusive = true } }
                }
            )
        }

        composable(
            route = Screen.Discover.route,
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) {
            DiscoverScreen(
                language    = lang,
                onGameClick = { navController.navigate(Screen.GameDetail.createRoute(it)) },
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
