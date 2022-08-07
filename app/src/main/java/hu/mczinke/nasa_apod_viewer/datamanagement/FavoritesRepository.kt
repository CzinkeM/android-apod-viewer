package hu.mczinke.nasa_apod_viewer.datamanagement

import androidx.lifecycle.LiveData
import hu.mczinke.nasa_apod_viewer.models.entities.ApodEntity

class FavoritesRepository(private val apodDao: ApodDao) {

    val allApod: LiveData<List<ApodEntity>> = apodDao.allApod()

    suspend fun addApod(apodEntity: ApodEntity) {
        apodDao.addApod(apodEntity)
    }

    suspend fun deleteApod(title: String) {
        apodDao.removeApodByTitle(title)
    }

    suspend fun deleteApodByTitle(title: String) {
        apodDao.removeApodByTitle(title)
    }

    fun getApodByTitle(title: String): LiveData<List<ApodEntity>> {
        return apodDao.getApodByTitle(title)
    }
}