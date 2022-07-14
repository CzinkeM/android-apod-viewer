package hu.mczinke.payment_manager.ui.components

import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import hu.mczinke.payment_manager.models.Apod
import hu.mczinke.payment_manager.viewmodels.MainViewModel


@Composable
fun HomeScreen(myViewModel: MainViewModel) {
    val apod: Apod by myViewModel.apod.observeAsState(Apod("", "", "", "", "", ""))

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





