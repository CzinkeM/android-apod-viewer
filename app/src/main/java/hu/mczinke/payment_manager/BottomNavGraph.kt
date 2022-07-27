package hu.mczinke.payment_manager

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hu.mczinke.payment_manager.ui.components.BottomBarScreen
import hu.mczinke.payment_manager.ui.components.FavoritesScreen
import hu.mczinke.payment_manager.ui.components.HomeScreen
import hu.mczinke.payment_manager.ui.components.SearchScreen
import hu.mczinke.payment_manager.viewmodels.MainViewModel
import hu.mczinke.payment_manager.viewmodels.SearchViewModel

@Composable
fun BottomNavGraph(
    homeViewModel: MainViewModel,
    searchViewModel: SearchViewModel,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(myViewModel = homeViewModel)
        }
        composable(route = BottomBarScreen.Search.route) {
            SearchScreen(viewModel = searchViewModel)
        }
        composable(route = BottomBarScreen.Favorites.route) {
            FavoritesScreen()
        }
    }
}