package hu.mczinke.nasa_apod_viewer.home.domain

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import hu.mczinke.nasa_apod_viewer.core.domain.NavigationDestiny
import hu.mczinke.nasa_apod_viewer.home.presentation.screen.HomeScreen

object HomeNavigation: NavigationDestiny {
    private const val route = "/home"

    override fun NavGraphBuilder.addGraph() {
        this.composable(route = this@HomeNavigation.route) {
            HomeScreen()
        }
    }

    override fun NavController.navigate() {
        this.navigate(this@HomeNavigation.route)
    }

    override fun route(): String {
        return route
    }
}