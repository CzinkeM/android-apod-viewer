package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.viewmodels.DatabaseRelatedViewModel

@Composable
fun FavoriteIcon(apod: Apod, viewModel: DatabaseRelatedViewModel, modifier: Modifier = Modifier) {
    // get from viewModel
    val isApodFavorite = remember { mutableStateOf(false) }

    if (isApodFavorite.value) {
        FilledFavoriteIcon(apod = apod, viewModel = viewModel, modifier = modifier)
    } else {
        OutlinedFavoriteIcon(apod = apod, viewModel = viewModel, modifier = modifier)
    }

}

@Composable
fun FilledFavoriteIcon(
    apod: Apod,
    viewModel: DatabaseRelatedViewModel,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .clickable {
                viewModel.deleteApodFromDatabase(apod)
                viewModel.isApodExist(apod)
            },
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_favorite_filled),
        contentDescription = "Filled hearth shaped icon."
    )
}

@Composable
fun OutlinedFavoriteIcon(
    apod: Apod,
    viewModel: DatabaseRelatedViewModel,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .clickable {
                viewModel.addApodToDatabase(apod)
                viewModel.isApodExist(apod)
            },
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_favorite_outline),
        contentDescription = "Hearth shaped icon."
    )
}