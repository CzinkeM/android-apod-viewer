package hu.mczinke.nasa_apod_viewer.home.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.mczinke.nasa_apod_viewer.BuildConfig
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.models.ApodMapper.toApod
import hu.mczinke.nasa_apod_viewer.home.data.ApodRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val apodRepository: ApodRepository
) : ViewModel() {

    private val _apod: MutableLiveData<Apod> = MutableLiveData()
    val apod: LiveData<Apod> = _apod

    fun getApod() {
        viewModelScope.launch {
            val result = apodRepository.getApod(BuildConfig.NASA_API_KEY)
            Log.d("Response", result.toString())
            _apod.value = result.toApod()
        }
    }
}