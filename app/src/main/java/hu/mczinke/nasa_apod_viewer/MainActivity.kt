package hu.mczinke.nasa_apod_viewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import hu.mczinke.nasa_apod_viewer.datamanagement.ApodDatabase
import hu.mczinke.nasa_apod_viewer.datamanagement.FavoritesRepository
import hu.mczinke.nasa_apod_viewer.ui.components.MainScreen
import hu.mczinke.nasa_apod_viewer.ui.theme.APODViewerTheme
import hu.mczinke.nasa_apod_viewer.viewmodels.FavoritesViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.HomeViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.Repository
import hu.mczinke.nasa_apod_viewer.viewmodels.SearchViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.factories.MainViewModelFactory
import hu.mczinke.nasa_apod_viewer.viewmodels.factories.SearchViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: HomeViewModel
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apodDao = ApodDatabase.getInstance(application).apodDao()
        val favoritesRepository = FavoritesRepository(apodDao)
        val repository = Repository()
        val homeViewModelFactory = MainViewModelFactory(repository, favoritesRepository)
        val searchViewModelFactory = SearchViewModelFactory(repository, favoritesRepository)
        //val favoriteViewModelFactory = FavoriteViewModelFactory(favoritesRepository)
        mainViewModel = ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
        searchViewModel =
            ViewModelProvider(this, searchViewModelFactory)[SearchViewModel::class.java]
        favoritesViewModel = ViewModelProvider(this)[FavoritesViewModel::class.java]
        mainViewModel.getApod()
        setContent {
            APODViewerTheme {
                MainScreen(mainViewModel, searchViewModel, favoritesViewModel)
            }
        }
    }
}



