package hu.mczinke.nasa_apod_viewer.search.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.mczinke.nasa_apod_viewer.core.domain.Apod

@Composable
fun SearchResultList(
    modifier: Modifier = Modifier,
    items: List<Apod>
) {
    LazyColumn(modifier = modifier) {
        items(items) {apod ->
            ApodListItem(apod = apod)
        }
    }
}