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
) : ViewModel() {

    private val _apod: MutableLiveData<Apod> = MutableLiveData()
    val apod: LiveData<Apod> = _apod

    fun getApod() {
        viewModelScope.launch {
            val result = repository.getApod(BuildConfig.NASA_API_KEY)
            Log.d("Response", result.toString())
            _apod.value = result.toApod()
        }
    }

    fun addApodToFavorites(apod: Apod) {
        viewModelScope.launch {
            val apodEntity = apod.toEntity()
            favoritesRepository.addApod(apodEntity)
            Log.d("Home Action", "$apodEntity added to favorites.")
        }
    }
}