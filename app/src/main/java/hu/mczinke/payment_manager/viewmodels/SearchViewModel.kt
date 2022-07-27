package hu.mczinke.payment_manager.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.mczinke.payment_manager.BuildConfig
import hu.mczinke.payment_manager.models.Apod
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: Repository) : ViewModel() {

    private val _apods: MutableLiveData<List<Apod>> = MutableLiveData()
    val apods: LiveData<List<Apod>> = _apods

    fun getApodsInPeriod(startDate: String, endDate: String) {
        viewModelScope.launch {
            val result = repository.getApodsInPeriod(BuildConfig.NASA_API_KEY, startDate, endDate)
            Log.d("Response", result.toString())
            _apods.value = result.map { apodDto -> apodDto.toApod() }
        }
    }

    fun getApodsAtSpecificDate(date: String) {
        viewModelScope.launch {
            val result = repository.getApodAtSpecificDate(BuildConfig.NASA_API_KEY, date)
            Log.d("Response", result.toString())
            _apods.value = listOf(result.toApod())
        }
    }
}