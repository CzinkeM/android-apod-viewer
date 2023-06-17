package hu.mczinke.nasa_apod_viewer.home.di

import hu.mczinke.nasa_apod_viewer.home.data.ApodApi
import hu.mczinke.nasa_apod_viewer.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val homeModule = module {
    viewModel { HomeViewModel(get()) }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/planetary/apod/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApodApi::class.java)
    }
}