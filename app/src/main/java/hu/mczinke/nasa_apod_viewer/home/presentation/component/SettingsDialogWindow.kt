package hu.mczinke.nasa_apod_viewer.home.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import hu.mczinke.nasa_apod_viewer.ui.theme.ElectricOrange

@Composable
fun SettingsDialogWindow(modifier: Modifier = Modifier, onDismiss: () -> Unit) {

    var isDarkMode by remember {
        mutableStateOf(false)
    }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = modifier.fillMaxHeight(.9f),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, ElectricOrange)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Column(modifier = Modifier.weight(9f)) {
                    Text(text = "Settings")
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "Darkmode"
                        )
                        Switch(
                            modifier = Modifier.weight(1f),
                            checked = isDarkMode,
                            onCheckedChange = {
                                isDarkMode = !isDarkMode
                            }
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = Icons.Default.Info.name
                        )
                        Text(
                            text = "Info"
                        )
                    }
                    Text(text = "Every image, video and displayed data is provided by NASA (National Aeronautics and Space Administration)'s APOD API.")
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                ) {
                    Button(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = ElectricOrange
                        )
                    ) {
                        Text(text = "Back")
                    }
                }
            }

        }
    }
}