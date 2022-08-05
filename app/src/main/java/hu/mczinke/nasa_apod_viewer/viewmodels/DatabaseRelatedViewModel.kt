package hu.mczinke.nasa_apod_viewer.viewmodels

import androidx.lifecycle.LiveData
import hu.mczinke.nasa_apod_viewer.models.Apod

interface DatabaseRelatedViewModel {
    val apodExistInDatabase: LiveData<Boolean>

    fun isApodExist(apod: Apod)

    fun addApodToDatabase(apod: Apod)

    fun deleteApodFromDatabase(apod: Apod)

}