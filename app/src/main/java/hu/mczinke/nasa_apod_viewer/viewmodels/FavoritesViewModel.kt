package hu.mczinke.nasa_apod_viewer.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import hu.mczinke.nasa_apod_viewer.datamanagement.ApodDatabase
import hu.mczinke.nasa_apod_viewer.datamanagement.FavoritesRepository
import hu.mczinke.nasa_apod_viewer.models.entities.ApodEntity

class FavoritesViewModel(application: Application) : DatabaseViewModel(application) {

    private val _favorites: MutableLiveData<List<ApodEntity>> = MutableLiveData()
    val favorites: LiveData<List<ApodEntity>> = _favorites
    val mediator = MediatorLiveData<List<ApodEntity>>()
    private val repository: FavoritesRepository

    init {
        val apodDao = ApodDatabase.getInstance(application).apodDao()
        repository = FavoritesRepository(apodDao)
        mediator.addSource(repository.allApod) { _favorites.value = it }
    }
}