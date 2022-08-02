package hu.mczinke.nasa_apod_viewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import hu.mczinke.nasa_apod_viewer.ui.components.MainScreen
import hu.mczinke.nasa_apod_viewer.ui.theme.APODViewerTheme
import hu.mczinke.nasa_apod_viewer.viewmodels.FavoritesViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.MainViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.Repository
import hu.mczinke.nasa_apod_viewer.viewmodels.SearchViewModel
import hu.mczinke.nasa_apod_viewer.viewmodels.factories.FavoriteViewModelFactory
import hu.mczinke.nasa_apod_viewer.viewmodels.factories.MainViewModelFactory
import hu.mczinke.nasa_apod_viewer.viewmodels.factories.SearchViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val homeViewModelFactory = MainViewModelFactory(repository)
        val searchViewModelFactory = SearchViewModelFactory(repository)
        val favoriteViewModelFactory = FavoriteViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this, homeViewModelFactory)[MainViewModel::class.java]
        searchViewModel =
            ViewModelProvider(this, searchViewModelFactory)[SearchViewModel::class.java]
        favoritesViewModel =
            ViewModelProvider(this, favoriteViewModelFactory)[FavoritesViewModel::class.java]
        mainViewModel.getAPOD()
        setContent {
            APODViewerTheme {
                MainScreen(mainViewModel, searchViewModel, favoritesViewModel)
            }
        }
    }
}



