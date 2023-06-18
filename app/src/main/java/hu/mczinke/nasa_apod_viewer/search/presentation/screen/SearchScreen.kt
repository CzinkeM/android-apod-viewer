package hu.mczinke.nasa_apod_viewer.search.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import hu.mczinke.nasa_apod_viewer.search.presentation.SearchViewModel
import hu.mczinke.nasa_apod_viewer.search.presentation.components.SearchCard
import hu.mczinke.nasa_apod_viewer.search.presentation.components.SearchResultList
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = koinViewModel()
) {
    val resultList by viewModel.searchResult.collectAsState()

    Surface(modifier = modifier) {
        Column(modifier = Modifier.fillMaxSize()) {
            SearchCard()
            SearchResultList(items = resultList)
        }
    }
}