package hu.mczinke.nasa_apod_viewer.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.mczinke.nasa_apod_viewer.BuildConfig
import hu.mczinke.nasa_apod_viewer.datamanagement.FavoritesRepository
import hu.mczinke.nasa_apod_viewer.models.Apod
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository,
    private val favoritesRepository: FavoritesRepository
) : ViewModel(), DatabaseRelatedViewModel {

    private val _apod: MutableLiveData<Apod> = MutableLiveData()
    val apod: LiveData<Apod> = _apod

    private val _apodExist: MutableLiveData<Boolean> = MutableLiveData()
    override val apodExistInDatabase: LiveData<Boolean> = _apodExist

    fun getApod() {
        viewModelScope.launch {
            val result = repository.getApod(BuildConfig.NASA_API_KEY)
            Log.d("Response", result.toString())
            _apod.value = result.toApod()
        }
    }

    override fun isApodExist(apod: Apod) {
        _apodExist.value = favoritesRepository.isApodExistInDatabase(apod.title)
    }

    override fun addApodToDatabase(apod: Apod) {
        viewModelScope.launch {
            favoritesRepository.addApod(apod.toEntity())
            //TODO should unifies the logging messages
            Log.d("Database", "${apod.title} added to favorites.")
        }
        isApodExist(apod)
    }

    override fun deleteApodFromDatabase(apod: Apod) {
        viewModelScope.launch {
            favoritesRepository.deleteApodByTitle(apod.title)
            Log.d("Database", "${apod.title} deleted from favorites.")
        }
        isApodExist(apod)
    }
}