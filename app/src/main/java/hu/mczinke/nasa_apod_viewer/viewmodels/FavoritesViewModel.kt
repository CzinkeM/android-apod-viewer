package hu.mczinke.nasa_apod_viewer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hu.mczinke.nasa_apod_viewer.models.Apod

class FavoritesViewModel(repository: Repository) : ViewModel() {
    private val _apods: MutableLiveData<List<Apod>> = MutableLiveData()
    val apods: LiveData<List<Apod>> = _apods

    fun getFavoriteApods() {
        /*
        viewModelScope.launch {
            val result = repository.getApodsInPeriod(BuildConfig.NASA_API_KEY, dateFilter)
            Log.d("Response", result.toString())
            _apods.value = result.map { apodDto -> apodDto.toApod() }
        }
         */
    }
}