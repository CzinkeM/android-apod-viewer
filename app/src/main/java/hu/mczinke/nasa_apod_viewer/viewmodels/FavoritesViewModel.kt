package hu.mczinke.nasa_apod_viewer.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import hu.mczinke.nasa_apod_viewer.datamanagement.ApodDatabase
import hu.mczinke.nasa_apod_viewer.datamanagement.FavoritesRepository
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.models.entities.ApodEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<ApodEntity>>

    private val _favorites: MutableLiveData<List<Apod>> = MutableLiveData()
    val favorites: LiveData<List<Apod>> = _favorites
    private val repository: FavoritesRepository

    init {
        val apodDao = ApodDatabase.getInstance(application).apodDao()
        repository = FavoritesRepository(apodDao)
        readAllData = repository.allApod
    }

    fun getAllFavoriteApods() {
        //readAllData.value = repository.allApod.value
    }

    fun deleteFavoriteApod(apod: Apod) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteApod(apod.toEntity())
            Log.d("Database", "Favorite Apods added: $apod")
        }
    }

    fun addFavoriteApod(apod: Apod) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addApod(apod.toEntity())
            Log.d("Database", "Favorite Apods added: $apod")

        }
    }
}