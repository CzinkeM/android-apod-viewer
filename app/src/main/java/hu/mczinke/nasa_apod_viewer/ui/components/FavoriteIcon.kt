package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor
import hu.mczinke.nasa_apod_viewer.viewmodels.DatabaseRelatedViewModel

@Composable
fun FavoriteIcon(
    iconScale: Float,
    apod: Apod,
    viewModel: DatabaseRelatedViewModel,
    modifier: Modifier = Modifier
) {
    val isApodFavorite = remember { mutableStateOf(false) }

    IconToggleButton(
        modifier = modifier,
        checked = isApodFavorite.value,
        onCheckedChange = { checked ->
            if (checked) {
                isApodFavorite.value = true
                viewModel.addApodToDatabase(apod)
            } else {
                isApodFavorite.value = false
                viewModel.deleteApodFromDatabase(apod)
            }
        }) {
        if (isApodFavorite.value) {
            FilledFavoriteIcon(modifier = modifier, iconScale = iconScale)
        } else {
            OutlinedFavoriteIcon(modifier = modifier, iconScale = iconScale)
        }
    }
}

@Composable
fun FilledFavoriteIcon(modifier: Modifier = Modifier, iconScale: Float) {
    Icon(
        modifier = modifier.fillMaxSize(iconScale),
        imageVector = Icons.Filled.Favorite,
        contentDescription = "Filled hearth shaped icon.",
        tint = VibrantColor
    )
}

@Composable
fun OutlinedFavoriteIcon(modifier: Modifier = Modifier, iconScale: Float) {
    Icon(
        modifier = modifier.fillMaxSize(iconScale),
        imageVector = Icons.Filled.FavoriteBorder,
        contentDescription = "Hearth shaped icon.",
        tint = SpacePrimaryVariant,
    )
}