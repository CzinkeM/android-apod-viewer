package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor

@Composable
fun SearchFloatingActionButton(modifier: Modifier = Modifier, onClickAction: () -> Unit) {
    FloatingActionButton(
        onClick = { onClickAction() },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = VibrantColor
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Floating Action Button"
        )
    }
}