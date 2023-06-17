package hu.mczinke.nasa_apod_viewer.home.presentation.component

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor

@Composable
fun ApodDescription(
    modifier: Modifier = Modifier,
    apod: Apod?
) {

    val scrollState = rememberScrollState()

    if(apod == null || apod.explanation.isEmpty()) {
        Spacer(modifier = modifier)
    }else {
        Column(
            modifier = modifier
        ) {
            Text(
                modifier = Modifier.align(CenterHorizontally).padding(16.dp),
                text = "Explanation"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                thickness = 2.dp,
                color = VibrantColor
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.verticalScroll(scrollState).padding(4.dp),
                text = apod.explanation,
                softWrap = true,
            )
        }
    }
}