package hu.mczinke.nasa_apod_viewer.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import hu.mczinke.nasa_apod_viewer.BuildConfig
import hu.mczinke.nasa_apod_viewer.models.Apod
import kotlinx.coroutines.launch

class HomeViewModel(
    application: Application,
    private val repository: Repository
) : DatabaseViewModel(application) {

    private val _apod: MutableLiveData<Apod> = MutableLiveData()
    val apod: LiveData<Apod> = _apod

    var apodExistInDatabase = _apod.value?.let { isApodExist(it) }

    fun getApod() {
        viewModelScope.launch {
            val result = repository.getApod(BuildConfig.NASA_API_KEY)
            Log.d("Response", result.toString())
            _apod.value = result.toApod()
        }
    }
}