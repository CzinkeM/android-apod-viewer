package hu.mczinke.nasa_apod_viewer.viewmodels

import hu.mczinke.nasa_apod_viewer.models.Apod

interface DatabaseRelatedViewModel {

    fun isApodExist(apod: Apod): Boolean

    fun addApodToDatabase(apod: Apod)

    fun deleteApodFromDatabase(apod: Apod)

    fun addOrDeleteApodDependOnExistenceInDatabase(apod: Apod)

}