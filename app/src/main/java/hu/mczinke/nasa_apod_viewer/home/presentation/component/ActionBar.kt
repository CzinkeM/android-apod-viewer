package hu.mczinke.nasa_apod_viewer.home.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
) {
    var showSettingsDialog by remember {
        mutableStateOf(false)
    }
    if(showSettingsDialog) {
        SettingsDialogWindow {
            showSettingsDialog = false
        }
    }


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
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = Icons.Default.Share.name
                )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = { /*TODO*/ }
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
                    .background(VibrantColor),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = Icons.Default.Search.name
                )
            }
        }
    }
}