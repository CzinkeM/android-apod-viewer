package hu.mczinke.nasa_apod_viewer.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.mczinke.nasa_apod_viewer.datamanagement.FavoritesRepository
import hu.mczinke.nasa_apod_viewer.viewmodels.HomeViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.Repository

class MainViewModelFactory(
    private val repository: Repository,
    private val favoritesRepository: FavoritesRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository, favoritesRepository) as T
    }
}