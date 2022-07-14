package hu.mczinke.payment_manager.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import hu.mczinke.payment_manager.BottomNavGraph
import hu.mczinke.payment_manager.ui.theme.SpaceBlackVariant
import hu.mczinke.payment_manager.viewmodels.MainViewModel

@Composable
fun MainScreen(homeViewModel: MainViewModel) {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController) }) {
        BottomNavGraph(navHostController = navController, homeViewModel = homeViewModel)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Search,
        BottomBarScreen.Favorites,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        elevation = 0.dp,
        backgroundColor = SpaceBlackVariant,
        modifier = Modifier
            .border(0.dp, Color.Transparent, RoundedCornerShape(16.dp))
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 16.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {

        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = ""
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}