package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.models.Apod

@Composable
fun ApodImageDialog(modifier: Modifier = Modifier, apod: Apod, onCancel: () -> Unit) {
    AlertDialog(
        shape = RoundedCornerShape(8.dp),
        onDismissRequest = {
            onCancel()
        },
        title = {
            Text(text = apod.title)
        },
        text = {
            Column {
                ApodBigImage(
                    modifier = Modifier
                        .fillMaxSize(1f)
                        .align(CenterHorizontally),
                    apod = apod
                )
                if(apod.copyright != null) {
                    ApodAuthor(author = apod.copyright)
                }
                ApodExplanation(explanation = apod.explanation)
            }
        },
        buttons = {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextButton(
                    modifier = Modifier.fillMaxWidth(0.3f),
                    onClick = { onCancel() }
                ) {
                    Text("Cancel")
                }
            }
        }
    )
}

@Composable
fun SearchDialog(onCancel: () -> Unit) {
    var text by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = {
            onCancel()
        },
        title = {
            Text(text = "Title")
        },
        text = {
            Column {
                TextField(
                    value = text,
                    onValueChange = { text = it }
                )
                Spacer(modifier = Modifier.fillMaxWidth(0.9f))
                Checkbox(checked = false, onCheckedChange = {})
            }
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onCancel()
                    }
                ) {
                    Text("Dismiss")
                }
            }
        }
    )

}