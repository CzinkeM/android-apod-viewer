package hu.mczinke.nasa_apod_viewer.search.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.core.domain.Apod

@Composable
fun ApodListItem(
    modifier: Modifier = Modifier,
    apod: Apod
) {
    Box(modifier = Modifier.size(100.dp))
}