package hu.mczinke.payment_manager.nasa_api

import hu.mczinke.payment_manager.models.DTOs.ApodDto
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.nasa.gov/index.html

interface ApodApi {
    @GET("/planetary/apod")
    suspend fun getApod(@Query("api_key") apiKey: String): ApodDto

    @GET("/planetary/apod")
    suspend fun getApodsInPeriod(
        @Query("api_key") apiKey: String,
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String
    ): List<ApodDto>

    @GET("/planetary/apod")
    suspend fun getApodAtSpecificDate(@Query("date") date: String): ApodDto
}