package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import hu.mczinke.nasa_apod_viewer.viewmodels.DatabaseRelatedViewModel

@Composable
fun ApodBigImage(apod: Apod, modifier: Modifier = Modifier) {

    GlideImage(
        imageModel = apod.HDUrl,
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

@Composable
fun ApodSmallImage(apod: Apod, modifier: Modifier = Modifier) {

    GlideImage(
        imageModel = apod.url,
        contentDescription = "Picture titled: ${apod.title}",
        contentScale = ContentScale.FillBounds,
        placeHolder = ImageVector.vectorResource(id = R.drawable.ic_image),
        error = ImageVector.vectorResource(id = R.drawable.ic_image),
        previewPlaceholder = R.drawable.ic_image,
        circularReveal = CircularReveal(150),
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun ApodBigImageWithFavoriteIcon(
    modifier: Modifier = Modifier,
    apod: Apod,
    viewModel: DatabaseRelatedViewModel,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        ApodBigImage(apod = apod)
        FavoriteIcon(
            apod = apod,
            viewModel = viewModel,
            iconScale = 0.2f,
            modifier = Modifier.align(
                Alignment.BottomStart
            )
        )
    }
}