package hu.mczinke.payment_manager.viewmodels

import hu.mczinke.payment_manager.BuildConfig
import hu.mczinke.payment_manager.nasa_api.APODApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/planetary/apod/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: APODApi by lazy {
        retrofit.create(APODApi::class.java)
    }
}