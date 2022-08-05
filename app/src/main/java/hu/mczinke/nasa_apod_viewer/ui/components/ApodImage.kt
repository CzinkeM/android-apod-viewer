package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.models.Apod

@Composable
fun ApodImage(apod: Apod, useHD: Boolean, modifier: Modifier = Modifier) {
    val url = if (useHD) {
        apod.HDUrl
    } else {
        apod.url
    }
    GlideImage(
        imageModel = url,
        contentDescription = "Picture titled: ${apod.title}",
        contentScale = ContentScale.FillHeight,
        placeHolder = ImageVector.vectorResource(id = R.drawable.ic_image),
        error = ImageVector.vectorResource(id = R.drawable.ic_image),
        previewPlaceholder = R.drawable.ic_image,
        circularReveal = CircularReveal(150),
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
    )
}