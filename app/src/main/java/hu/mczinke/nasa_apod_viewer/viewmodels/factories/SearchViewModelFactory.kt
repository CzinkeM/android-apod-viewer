package hu.mczinke.nasa_apod_viewer.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.mczinke.nasa_apod_viewer.viewmodels.Repository
import hu.mczinke.nasa_apod_viewer.viewmodels.SearchViewModel


class SearchViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchViewModel(repository) as T
    }
}