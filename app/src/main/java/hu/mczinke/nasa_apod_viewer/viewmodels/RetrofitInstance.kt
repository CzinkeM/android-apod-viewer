package hu.mczinke.nasa_apod_viewer.viewmodels

import hu.mczinke.nasa_apod_viewer.nasa_api.ApodApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/planetary/apod/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApodApi by lazy {
        retrofit.create(ApodApi::class.java)
    }
}