package hu.mczinke.nasa_apod_viewer.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.core.domain.Apod
import hu.mczinke.nasa_apod_viewer.ui.theme.ElectricOrange

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
            Divider(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                thickness = 2.dp,
                color = ElectricOrange
            )
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(scrollState),
                text = apod.explanation,
                softWrap = true,
            )
        }
    }
}