package hu.mczinke.nasa_apod_viewer.home.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.models.MediaType

@Composable
fun MediaContainer(
    modifier: Modifier = Modifier,
    apod: Apod?
) {
    if(apod == null) {
        Text(
            modifier = modifier,
            text = "Apod is null!"
        )
    }else {
        when(apod.mediaType) {
            MediaType.IMAGE -> ApodBigImage(
                modifier = modifier,
                apod = apod
            )
            MediaType.VIDEO -> ApodBigVideo(
                modifier = modifier,
                apod = apod
            )
        }
    }
}