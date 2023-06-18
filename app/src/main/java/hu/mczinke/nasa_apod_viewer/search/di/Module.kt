package hu.mczinke.nasa_apod_viewer.search.di

import hu.mczinke.nasa_apod_viewer.search.presentation.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    viewModel { SearchViewModel(get()) }
}