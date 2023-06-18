package hu.mczinke.nasa_apod_viewer.home.presentation.component

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.core.domain.Apod

@Composable
fun ApodBigImage(
    modifier: Modifier = Modifier,
    apod: Apod
) {
    GlideImage(
        imageModel = apod.HDUrl,
        contentDescription = "Picture titled: ${apod.title}",
        contentScale = ContentScale.FillWidth,
        error = ImageVector.vectorResource(id = R.drawable.ic_image),
        previewPlaceholder = R.drawable.ic_image,
        circularReveal = CircularReveal(1000),
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                    }
                )
            }
            .clip(RoundedCornerShape(8.dp))
    )
}