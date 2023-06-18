package hu.mczinke.nasa_apod_viewer.search.presentation

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import hu.mczinke.nasa_apod_viewer.core.data.ApodRepository
import hu.mczinke.nasa_apod_viewer.core.domain.Apod
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel(
    private val repository: ApodRepository
): ViewModel() {


    private val _searchResult = MutableStateFlow(emptyList<Apod>())
    val searchResult = _searchResult.asStateFlow()
}