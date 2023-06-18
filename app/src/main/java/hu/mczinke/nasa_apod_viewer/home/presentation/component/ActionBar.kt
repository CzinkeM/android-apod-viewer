package hu.mczinke.nasa_apod_viewer.home.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import hu.mczinke.nasa_apod_viewer.home.presentation.HomeViewModel
import hu.mczinke.nasa_apod_viewer.search.domain.SearchNavigation
import hu.mczinke.nasa_apod_viewer.ui.theme.ElectricOrange
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val context = LocalContext.current
    var showSettingsDialog by remember {
        mutableStateOf(false)
    }
    if(showSettingsDialog) {
        SettingsDialogWindow {
            showSettingsDialog = false
        }
    }
    val apod by viewModel.apod.collectAsState()


    Card(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    showSettingsDialog = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = Icons.Default.Settings.name
                )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                enabled = apod != null,
                onClick = {
                    viewModel.downloadImage(context)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = Icons.Default.Download.name
                )
            }
            IconButton(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(ElectricOrange),
                onClick = {
                    SearchNavigation.navigate(navController)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = Icons.Default.Search.name
                )
            }
        }
    }
}