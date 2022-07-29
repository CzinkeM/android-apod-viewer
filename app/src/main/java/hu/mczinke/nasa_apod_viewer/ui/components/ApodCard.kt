package hu.mczinke.nasa_apod_viewer.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.ui.preview_parameter_providers.ApodParameterProvider
import hu.mczinke.nasa_apod_viewer.ui.theme.SpaceBlackVariant

@Composable
@Preview
fun ApodCard(@PreviewParameter(ApodParameterProvider::class) apod: Apod) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(8.dp)
            .clickable {
                Toast
                    .makeText(context, "clicked", Toast.LENGTH_SHORT)
                    .show()
            },
        backgroundColor = SpaceBlackVariant,
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            GlideImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .weight(1f),
                imageModel = apod.url,
                contentDescription = "Picture named: ${apod.title}",
                contentScale = ContentScale.FillHeight,
                placeHolder = ImageVector.vectorResource(id = hu.mczinke.nasa_apod_viewer.R.drawable.ic_image),
                error = ImageVector.vectorResource(id = hu.mczinke.nasa_apod_viewer.R.drawable.ic_image),
                previewPlaceholder = hu.mczinke.nasa_apod_viewer.R.drawable.ic_image,
                circularReveal = CircularReveal(150)

            )
            Text(
                modifier = Modifier
                    .weight(2f),
                text = apod.title,
                textAlign = TextAlign.Center
            )
        }
    }
}