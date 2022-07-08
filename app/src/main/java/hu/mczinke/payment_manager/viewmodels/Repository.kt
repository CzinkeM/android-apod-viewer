package hu.mczinke.payment_manager.viewmodels

import hu.mczinke.payment_manager.models.APOD
import hu.mczinke.payment_manager.models.APODImage
import retrofit2.Call

class Repository {

    suspend fun getAPOD(apiKey: String): APOD {
        return RetrofitInstance.api.getAPOD(apiKey)
    }

    suspend fun getAPODImage(path: String): Call<APODImage> {
        return RetrofitInstance.api.getAPODImage(path)
    }
}