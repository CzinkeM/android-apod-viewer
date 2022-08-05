package hu.mczinke.nasa_apod_viewer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hu.mczinke.nasa_apod_viewer.ui.components.BottomBarScreen
import hu.mczinke.nasa_apod_viewer.ui.components.FavoritesScreen
import hu.mczinke.nasa_apod_viewer.ui.components.HomeScreen
import hu.mczinke.nasa_apod_viewer.ui.components.SearchScreen
import hu.mczinke.nasa_apod_viewer.viewmodels.FavoritesViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.HomeViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.SearchViewModel

@Composable
fun BottomNavGraph(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    searchViewModel: SearchViewModel,
    favoritesViewModel: FavoritesViewModel,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(viewModel = homeViewModel)
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(viewModel = searchViewModel)
        }
        composable(route = BottomBarScreen.Favorites.route) {
            FavoritesScreen(viewModel = favoritesViewModel)
        }
    }
}