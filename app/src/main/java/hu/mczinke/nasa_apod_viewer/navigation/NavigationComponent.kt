package hu.mczinke.nasa_apod_viewer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hu.mczinke.nasa_apod_viewer.home.presentation.screen.HomeScreen
import hu.mczinke.nasa_apod_viewer.ui.components.BottomBarScreen
import hu.mczinke.nasa_apod_viewer.ui.components.SearchScreen
import hu.mczinke.nasa_apod_viewer.ui.components.SplashScreen

@Composable
fun NavigationComponent(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = BottomBarScreen.Splash.route
    ) {
        composable(route = BottomBarScreen.Splash.route) {
            SplashScreen(navController = navHostController)
        }
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen()
        }
    }
}