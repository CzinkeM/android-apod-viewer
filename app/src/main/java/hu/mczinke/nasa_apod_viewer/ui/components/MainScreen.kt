package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import hu.mczinke.nasa_apod_viewer.BottomNavGraph
import hu.mczinke.nasa_apod_viewer.ui.theme.DimmedWhite
import hu.mczinke.nasa_apod_viewer.ui.theme.SpaceBlackVariant
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant

@Composable
fun MainScreen(
) {
    val showFloatingActionButton = remember { mutableStateOf(false) }
    val showBottomAppBar = remember { mutableStateOf(false) }
    val navController = rememberNavController()
    navController.addOnDestinationChangedListener { controller, destination, arguments ->
        // react on change
        // you can check destination.id or destination.label and act based on that
        showBottomAppBar.value = destination.route != BottomBarScreen.Splash.route
        showFloatingActionButton.value = destination.route == BottomBarScreen.Search.route
    }

    Scaffold(
        bottomBar = {
            if (showBottomAppBar.value) {
                BottomBar(navController)
            }
        },
        floatingActionButton = {
            //TODO: Make animation here
            if (showFloatingActionButton.value) {
                SearchFloatingActionButton()
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
        ) {

            BottomNavGraph(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = paddingValues.calculateBottomPadding(), top = 50.dp),
                navHostController = navController,
            )
        }
        /*

         */
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
            .padding(start = 4.dp, end = 4.dp, top = 4.dp, bottom = 8.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentColor = DimmedWhite,
    ) {

        screens.forEach { screen ->
            if (screen.route != BottomBarScreen.Splash.route) {
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
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
        },
        selectedContentColor = SpacePrimaryVariant,
        unselectedContentColor = DimmedWhite,
    )
}