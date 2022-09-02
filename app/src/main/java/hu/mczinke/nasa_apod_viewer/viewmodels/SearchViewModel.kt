package hu.mczinke.nasa_apod_viewer.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import hu.mczinke.nasa_apod_viewer.BuildConfig
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.models.DateFilter
import kotlinx.coroutines.launch

class SearchViewModel(
    application: Application,
    private val repository: Repository,
) : DatabaseViewModel(application) {

    private val _apods: MutableLiveData<List<Apod>> = MutableLiveData()
    val apods: LiveData<List<Apod>> = _apods

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getApodsInPeriod(dateFilter: DateFilter) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = repository.getApodsInPeriod(BuildConfig.NASA_API_KEY, dateFilter)
            Log.d("Response", result.toString())
            _apods.value = result.map { apodDto -> apodDto.toApod() }
            _isLoading.value = false
        }
    }

    fun getApodsAtSpecificDate(dateFilter: DateFilter) {
        viewModelScope.launch {
            val result = repository.getApodAtSpecificDate(BuildConfig.NASA_API_KEY, dateFilter)
            Log.d("Response", result.toString())
            _apods.value = listOf(result.toApod())
        }
    }

    fun cleanApodList() {
        _apods.value = emptyList()
    }
}