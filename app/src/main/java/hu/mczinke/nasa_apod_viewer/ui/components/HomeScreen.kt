package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.viewmodels.MainViewModel


@Composable
fun HomeScreen(myViewModel: MainViewModel) {
    val apod: Apod by myViewModel.apod.observeAsState(Apod.nullApod())

    APODContainer(apod = apod)
}

@Composable
fun ExplanationModalDrawer(explanation: String) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Text(text = explanation)
        }
    ) {}
}





