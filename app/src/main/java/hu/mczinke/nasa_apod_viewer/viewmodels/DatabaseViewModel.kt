package hu.mczinke.nasa_apod_viewer.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import hu.mczinke.nasa_apod_viewer.datamanagement.ApodDatabase
import hu.mczinke.nasa_apod_viewer.datamanagement.FavoritesRepository
import hu.mczinke.nasa_apod_viewer.models.Apod
import kotlinx.coroutines.launch

abstract class DatabaseViewModel(application: Application) : AndroidViewModel(application),
    DatabaseRelatedViewModel {

    private val repository: FavoritesRepository

    init {
        val apodDao = ApodDatabase.getInstance(application).apodDao()
        repository = FavoritesRepository(apodDao)
    }

    override fun addOrDeleteApodDependOnExistenceInDatabase(apod: Apod) {
        if (isApodExist(apod)) {
            deleteApodFromDatabase(apod)
        } else {
            addApodToDatabase(apod)
        }
    }

    override fun isApodExist(apod: Apod): Boolean {
        return repository.isApodExist(apod.title)
    }

    override fun addApodToDatabase(apod: Apod) {
        viewModelScope.launch {
            repository.addApod(apod.toEntity())
            Log.d("Database", "${apod.title} added to favorites.")
        }
        isApodExist(apod)
    }


    override fun deleteApodFromDatabase(apod: Apod) {
        viewModelScope.launch {
            repository.deleteApodByTitle(apod.title)
            Log.d("Database", "${apod.title} deleted from favorites.")
        }
        isApodExist(apod)
    }
}