package hu.mczinke.nasa_apod_viewer.viewmodels.factories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.mczinke.nasa_apod_viewer.viewmodels.HomeViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.Repository

class MainViewModelFactory(
    private val application: Application,
    private val repository: Repository,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(application, repository) as T
    }
}