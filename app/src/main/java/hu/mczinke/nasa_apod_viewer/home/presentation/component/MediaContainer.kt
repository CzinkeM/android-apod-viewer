package hu.mczinke.nasa_apod_viewer.home.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.mczinke.nasa_apod_viewer.core.domain.Apod
import hu.mczinke.nasa_apod_viewer.core.domain.MediaType

@Composable
fun MediaContainer(
    modifier: Modifier = Modifier,
    apod: Apod?
) {
    if(apod == null) {
        WaitForApodLoadAnimation(
            modifier = modifier
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