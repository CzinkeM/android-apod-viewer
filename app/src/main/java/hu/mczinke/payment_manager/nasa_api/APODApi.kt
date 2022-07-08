package hu.mczinke.payment_manager.nasa_api

import hu.mczinke.payment_manager.models.APOD
import hu.mczinke.payment_manager.models.APODImage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

//https://api.nasa.gov/index.html

interface APODApi {
    @GET("/planetary/apod")
    suspend fun getAPOD(@Query("api_key") apiKey: String): APOD

    @GET
    suspend fun getAPODImage(@Url path: String): Call<APODImage>
}