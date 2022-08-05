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

class FavoritesViewModel(application: Application) : AndroidViewModel(application),
    DatabaseRelatedViewModel {

    private val _favorites: MutableLiveData<List<ApodEntity>> = MutableLiveData()
    val favorites: LiveData<List<ApodEntity>> = _favorites
    val mediator = MediatorLiveData<List<ApodEntity>>()
    private val repository: FavoritesRepository

    init {
        val apodDao = ApodDatabase.getInstance(application).apodDao()
        repository = FavoritesRepository(apodDao)
        mediator.addSource(repository.allApod) { _favorites.value = it }
    }

    override val apodExistInDatabase: LiveData<Boolean>
        get() = TODO("Not yet implemented")

    override fun isApodExist(apod: Apod) {
        TODO("Not yet implemented")
    }

    override fun addApodToDatabase(apod: Apod) {
        TODO("Not yet implemented")
    }

    override fun deleteApodFromDatabase(apod: Apod) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteApod(apod.title)
            Log.d("Database", "Favorite Apods added: ${apod.title}")
        }
    }
}