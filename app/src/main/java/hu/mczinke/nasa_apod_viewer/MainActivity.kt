package hu.mczinke.nasa_apod_viewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import hu.mczinke.nasa_apod_viewer.ui.components.MainScreen
import hu.mczinke.nasa_apod_viewer.ui.theme.APODViewerTheme
import hu.mczinke.nasa_apod_viewer.viewmodels.*

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val homeViewModelFactory = MainViewModelFactory(repository)
        val searchViewModelFactory = SearchViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this, homeViewModelFactory)[MainViewModel::class.java]
        searchViewModel =
            ViewModelProvider(this, searchViewModelFactory)[SearchViewModel::class.java]
        mainViewModel.getAPOD()
        setContent {
            APODViewerTheme {
                MainScreen(mainViewModel, searchViewModel)
            }
        }
    }
}



