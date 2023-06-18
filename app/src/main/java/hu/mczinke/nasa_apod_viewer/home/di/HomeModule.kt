package hu.mczinke.nasa_apod_viewer.home.di

import hu.mczinke.nasa_apod_viewer.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    viewModel { HomeViewModel(apodRepository = get()) }
}