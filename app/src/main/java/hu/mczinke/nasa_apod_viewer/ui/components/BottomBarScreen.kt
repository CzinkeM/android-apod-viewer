package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Favorites : BottomBarScreen(
        route = "favorites",
        title = "Favorites",
        icon = Icons.Default.Star
    )

    object Search : BottomBarScreen(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )

    object Splash : BottomBarScreen(
        route = "splash",
        title = "Splash",
        icon = Icons.Default.Settings
    )
}