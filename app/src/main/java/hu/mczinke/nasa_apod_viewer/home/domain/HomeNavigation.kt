package hu.mczinke.nasa_apod_viewer.home.domain

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import hu.mczinke.nasa_apod_viewer.core.domain.NavDestination
import hu.mczinke.nasa_apod_viewer.home.presentation.screen.HomeScreen

object HomeNavigation: NavDestination {
    private const val route = "/home"

    override fun addGraph(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route = this@HomeNavigation.route) {
            HomeScreen(navController = navController)
        }
    }

    override fun navigate(navController: NavController) {
        navController.navigate(this@HomeNavigation.route)
    }

    override fun route(): String {
        return route
    }
}