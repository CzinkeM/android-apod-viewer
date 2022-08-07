package hu.mczinke.nasa_apod_viewer.viewmodels.factories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.mczinke.nasa_apod_viewer.viewmodels.FavoritesViewModel

class FavoriteViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavoritesViewModel(application) as T
    }
}