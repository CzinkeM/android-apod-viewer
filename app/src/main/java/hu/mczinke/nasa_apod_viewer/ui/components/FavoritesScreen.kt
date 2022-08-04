package hu.mczinke.nasa_apod_viewer.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.ui.preview_parameter_providers.ApodParameterProvider
import hu.mczinke.nasa_apod_viewer.viewmodels.FavoritesViewModel

@Composable
fun FavoritesScreen(viewModel: FavoritesViewModel) {
    val mediator by viewModel.mediator.observeAsState()
    val apods by viewModel.favorites.observeAsState(listOf())

    LazyColumn {
        item { FavoritesTitle(viewModel = viewModel) }
        items(items = apods) { apod ->
            Text(text = apod.title, Modifier.clickable {
                viewModel.deleteFavoriteApod(apod)
            })
            //FavoritesApodCard(apod = apod)
        }
    }
}

@Composable
fun FavoritesTitle(viewModel: FavoritesViewModel) {
    Column {
        Text(text = "Favorites")
        Button(onClick = {
            Log.d("Database", "get apods")
        }) {}
    }

}

@Preview
@Composable
fun FavoritesApodCard(@PreviewParameter(ApodParameterProvider::class) apod: Apod) {
    Box {
        ApodCard(apod = apod)
        Image(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .fillMaxWidth(0.15f)
                .padding(8.dp)
                .clickable {
                    Log.d("Action", "removed apod: " + apod.title)
                },
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_remove),
            contentDescription = ""
        )// TODO:  fill
    }
}