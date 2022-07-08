package hu.mczinke.payment_manager.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.mczinke.payment_manager.BuildConfig
import hu.mczinke.payment_manager.models.APOD
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _apod: MutableLiveData<APOD> = MutableLiveData()
    val apod: LiveData<APOD> = _apod

    fun getAPOD() {
        viewModelScope.launch {
            val result = repository.getAPOD(BuildConfig.NASA_API_KEY)
            Log.d("Response", result.toString())
            _apod.value = result
        }
    }
}