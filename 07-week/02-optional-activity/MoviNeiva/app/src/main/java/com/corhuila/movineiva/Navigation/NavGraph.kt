package com.corhuila.movineiva.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.corhuila.movineiva.ui.HomeScreen
import com.corhuila.movineiva.ui.RouteDetailScreen

object Routes {
    const val HOME = "home"
    const val DETAIL = "detail/{routeId}"
    fun detail(routeId: String) = "detail/$routeId"
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onRouteClick = { routeId ->
                    navController.navigate(Routes.detail(routeId))
                }
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("routeId") { type = NavType.StringType })
        ) { backStackEntry ->
            val routeId = backStackEntry.arguments?.getString("routeId") ?: ""
            RouteDetailScreen(
                routeId = routeId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
