package hu.mczinke.nasa_apod_viewer.search.domain

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import hu.mczinke.nasa_apod_viewer.core.domain.NavDestination
import hu.mczinke.nasa_apod_viewer.home.presentation.screen.HomeScreen
import hu.mczinke.nasa_apod_viewer.search.presentation.screen.SearchScreen

object SearchNavigation: NavDestination {
    private const val route = "/search"

    override fun addGraph(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(route = this@SearchNavigation.route) {
            SearchScreen()
        }
    }

    override fun navigate(navController: NavController) {
        navController.navigate(this@SearchNavigation.route)
    }

    override fun route(): String {
        return route
    }
}