package hu.mczinke.nasa_apod_viewer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import hu.mczinke.nasa_apod_viewer.home.domain.HomeNavigation
import hu.mczinke.nasa_apod_viewer.search.domain.SearchNavigation

@Composable
fun NavigationComponent(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = HomeNavigation.route()
    ) {
        HomeNavigation.addGraph(this, navHostController)

        SearchNavigation.addGraph(this, navHostController)
    }
}