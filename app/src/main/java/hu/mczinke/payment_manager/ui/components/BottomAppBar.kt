package hu.mczinke.payment_manager.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hu.mczinke.payment_manager.ui.theme.SpaceBlackVariant
import hu.mczinke.payment_manager.ui.theme.SpacePrimary
import hu.mczinke.payment_manager.ui.theme.SpacePrimaryVariant


@Preview
@Composable
fun BottomAppBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 0.dp,
        backgroundColor = SpaceBlackVariant,
    ) {

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Favorite, "") },
            label = { Text(text = "Favorites") },
            selected = (selectedIndex.value == 0),
            onClick = { selectedIndex.value = 0 },
            selectedContentColor = SpacePrimaryVariant,
            unselectedContentColor = SpacePrimary
        )

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Home, "") },
            label = { Text(text = "Home") },
            selected = (selectedIndex.value == 1),
            onClick = { selectedIndex.value = 1 },
            selectedContentColor = SpacePrimaryVariant,
            unselectedContentColor = SpacePrimary
        )

        BottomNavigationItem(
            icon = { Icon(imageVector = Icons.Default.Search, "") },
            label = { Text(text = "Search") },
            selected = (selectedIndex.value == 2),
            onClick = { selectedIndex.value = 2 },
            selectedContentColor = SpacePrimaryVariant,
            unselectedContentColor = SpacePrimary
        )
    }
}