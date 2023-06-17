package hu.mczinke.nasa_apod_viewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import hu.mczinke.nasa_apod_viewer.ui.components.MainScreen
import hu.mczinke.nasa_apod_viewer.ui.theme.APODViewerTheme
import hu.mczinke.nasa_apod_viewer.viewmodels.Repository

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        setContent {
            APODViewerTheme {
                MainScreen()
            }
        }
    }
}



