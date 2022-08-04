package hu.mczinke.nasa_apod_viewer.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import hu.mczinke.nasa_apod_viewer.datamanagement.ApodDatabase
import hu.mczinke.nasa_apod_viewer.datamanagement.FavoritesRepository
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.models.entities.ApodEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    private val _favorites: MutableLiveData<List<ApodEntity>> = MutableLiveData()
    val favorites: LiveData<List<ApodEntity>> = _favorites
    val mediator = MediatorLiveData<List<ApodEntity>>()
    private val repository: FavoritesRepository

    init {
        val apodDao = ApodDatabase.getInstance(application).apodDao()
        repository = FavoritesRepository(apodDao)
        mediator.addSource(repository.allApod) { _favorites.value = it }
    }

    fun deleteFavoriteApod(apodEntity: ApodEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteApod(apodEntity)
            Log.d("Database", "Favorite Apods added: $apodEntity")
        }
    }

    fun addFavoriteApod(apod: Apod) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addApod(apod.toEntity())
            Log.d("Database", "Favorite Apods added: $apod")

        }
    }
}