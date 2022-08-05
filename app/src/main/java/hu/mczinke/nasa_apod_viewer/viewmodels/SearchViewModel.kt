package hu.mczinke.nasa_apod_viewer.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.mczinke.nasa_apod_viewer.BuildConfig
import hu.mczinke.nasa_apod_viewer.datamanagement.FavoritesRepository
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.models.DateFilter
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: Repository,
    private val favoritesRepository: FavoritesRepository
) : ViewModel(), DatabaseRelatedViewModel {

    private val _apods: MutableLiveData<List<Apod>> = MutableLiveData()
    val apods: LiveData<List<Apod>> = _apods

    private val _apodExist: MutableLiveData<Boolean> = MutableLiveData()
    override val apodExistInDatabase: LiveData<Boolean> = _apodExist

    fun getApodsInPeriod(dateFilter: DateFilter) {
        viewModelScope.launch {
            val result = repository.getApodsInPeriod(BuildConfig.NASA_API_KEY, dateFilter)
            Log.d("Response", result.toString())
            _apods.value = result.map { apodDto -> apodDto.toApod() }
        }
    }

    fun getApodsAtSpecificDate(dateFilter: DateFilter) {
        viewModelScope.launch {
            val result = repository.getApodAtSpecificDate(BuildConfig.NASA_API_KEY, dateFilter)
            Log.d("Response", result.toString())
            _apods.value = listOf(result.toApod())
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