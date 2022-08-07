package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import hu.mczinke.nasa_apod_viewer.models.entities.toApod
import hu.mczinke.nasa_apod_viewer.viewmodels.FavoritesViewModel

@Composable
fun FavoritesScreen(viewModel: FavoritesViewModel) {
    val mediator by viewModel.mediator.observeAsState()
    val apods by viewModel.favorites.observeAsState(listOf())

    LazyColumn {
        item { FavoritesTitle() }
        items(items = apods) { entity ->
            ApodCard(
                apod = entity.toApod(),
                allowAddToFavorite = false,
                allowDeleteFromFavorite = true,
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun FavoritesTitle() {
    Column {
        Text(text = "Favorites")
    }

}