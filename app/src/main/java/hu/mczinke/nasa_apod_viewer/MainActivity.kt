package hu.mczinke.nasa_apod_viewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import hu.mczinke.nasa_apod_viewer.navigation.NavigationComponent
import hu.mczinke.nasa_apod_viewer.ui.theme.APODViewerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            APODViewerTheme {
                NavigationComponent(Modifier)
            }
        }
    }
}



