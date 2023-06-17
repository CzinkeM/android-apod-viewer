package hu.mczinke.nasa_apod_viewer.home.presentation.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.home.presentation.HomeViewModel
import hu.mczinke.nasa_apod_viewer.home.presentation.component.ApodDescription
import hu.mczinke.nasa_apod_viewer.home.presentation.component.MediaContainer
import hu.mczinke.nasa_apod_viewer.ui.components.ActionBar
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

// TODO: constructor
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val apod by viewModel.apod.collectAsState()
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    Surface(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxSize()) {
            MediaContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f)
                    .padding(16.dp)
                    .border(2.dp, VibrantColor, RoundedCornerShape(8.dp))
                    .background(Color.Black,RoundedCornerShape(8.dp)),
                apod = apod,
            )
            ApodDescription(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.8f)
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                    .border(2.dp, VibrantColor, RoundedCornerShape(8.dp)),
                apod = apod
            )
            ActionBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
                    .padding()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
                    .border(2.dp, VibrantColor, RoundedCornerShape(8.dp)),
            )
        }

    }
}



