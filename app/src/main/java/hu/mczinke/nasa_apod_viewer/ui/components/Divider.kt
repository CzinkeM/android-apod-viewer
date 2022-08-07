package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant

@Composable
fun OrDivider() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(
            color = SpacePrimaryVariant,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(8.dp, 0.dp)
                .align(Alignment.CenterStart)
        )
        Text(text = "or", color = SpacePrimaryVariant, modifier = Modifier.align(Alignment.Center))
        Divider(
            color = SpacePrimaryVariant,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(8.dp, 0.dp)
                .align(Alignment.CenterEnd)
        )
    }
}