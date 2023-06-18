package hu.mczinke.nasa_apod_viewer.core.di

import hu.mczinke.nasa_apod_viewer.core.data.ApodApi
import hu.mczinke.nasa_apod_viewer.core.data.ApodRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val coreModule = module {
    single<ApodApi> {
        Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/planetary/apod/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApodApi::class.java)
    }

    single {
        ApodRepository(api = get())
    }
}