package hu.mczinke.payment_manager.ui.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import hu.mczinke.payment_manager.models.APOD
import hu.mczinke.payment_manager.viewmodels.MainViewModel


@Composable
fun HomeScreen(myViewModel: MainViewModel) {
    val apod: APOD by myViewModel.apod.observeAsState(APOD("", "", "", "", "", "", "", ""))
    ScaffoldWithBottomMenu(apod)
}

@Composable
fun ScaffoldWithBottomMenu(apod: APOD) {
    Scaffold(
        bottomBar = { BottomAppBar() }) {
        APODContainer(apod = apod)
    }
}





