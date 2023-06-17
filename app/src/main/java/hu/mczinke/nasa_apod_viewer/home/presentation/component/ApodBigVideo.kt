package hu.mczinke.nasa_apod_viewer.home.presentation.component

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.models.Apod

private const val TAG = "ApodBigVideo"
@Composable
fun ApodBigVideo(
    modifier: Modifier = Modifier,
    apod: Apod
) {
    val context = LocalContext.current
    val videoId by remember {
        mutableStateOf(extractVideoIdFromUrl(apod.HDUrl))
    }

    GlideImage(
        imageModel = transformYoutubeLinkToImageQueryLink(videoId),
        contentDescription = "Picture titled: ${apod.title}",
        contentScale = ContentScale.FillHeight,
        error = ImageVector.vectorResource(id = R.drawable.ic_image),
        previewPlaceholder = R.drawable.ic_image,
        circularReveal = CircularReveal(1000),
        modifier = modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        startYoutubeVideo(context, videoId)
                    }
                )
            }
            .clip(RoundedCornerShape(8.dp))
    )
}

private fun transformYoutubeLinkToImageQueryLink(videoId: String): String {
    val imageLinkTemplate = "https://img.youtube.com/vi/id/0.jpg"
    return imageLinkTemplate.replace("id", videoId)
}

private fun extractVideoIdFromUrl(url: String): String {
    return url.substring(url.lastIndexOf("/") + 1, url.indexOf('?'))
}

private fun startYoutubeVideo(context: Context, videoId: String) {
    Log.d(TAG, "startYoutubeVideo: $videoId")
    val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://$videoId"))
    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=$videoId"))

    try {
        context.startActivity(appIntent)
        Log.d(TAG, "startYoutubeVideo: app started")
    } catch (ex: ActivityNotFoundException) {
        context.startActivity(webIntent)
        Log.d(TAG, "startYoutubeVideo: web started")
    }catch (e : Exception) {
        throw e
    }
}