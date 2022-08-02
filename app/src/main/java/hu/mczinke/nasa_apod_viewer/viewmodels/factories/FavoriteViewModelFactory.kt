package hu.mczinke.nasa_apod_viewer.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.mczinke.nasa_apod_viewer.viewmodels.FavoritesViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.Repository

class FavoriteViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavoritesViewModel(repository) as T
    }
}