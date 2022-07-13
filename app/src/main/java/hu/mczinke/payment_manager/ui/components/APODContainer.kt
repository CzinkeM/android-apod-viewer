package hu.mczinke.payment_manager.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import hu.mczinke.payment_manager.R
import hu.mczinke.payment_manager.models.APOD
import hu.mczinke.payment_manager.ui.preview_parameter_providers.APODParameterProvider
import hu.mczinke.payment_manager.ui.preview_parameter_providers.StringParameterProvider
import hu.mczinke.payment_manager.ui.theme.SpaceBlack
import hu.mczinke.payment_manager.ui.theme.SpacePrimary
import hu.mczinke.payment_manager.ui.theme.SpacePrimaryVariant

@Preview
@Composable
fun APODContainer(@PreviewParameter(APODParameterProvider::class) apod: APOD) {
    Surface(modifier = Modifier.background(SpaceBlack)) {
        Column(
            modifier = Modifier
                .background(SpaceBlack)
                .padding(8.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            APODImageContainer(url = apod.url)
            APODTitle(apod.title)
            APODAuthor(
                when (apod.copyright) {
                    null -> ""
                    else -> "(${apod.copyright})"
                }
            )
            ExplanationButton()
        }
    }

}

@Preview
@Composable
fun APODTitle(@PreviewParameter(StringParameterProvider::class) title: String) {
    Text(
        text = title,
        fontFamily = FontFamily.SansSerif,
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.W400,
        color = SpacePrimaryVariant,
        modifier = Modifier.padding(0.dp, 16.dp)
    )
}

@Preview
@Composable
fun APODAuthor(@PreviewParameter(StringParameterProvider::class) author: String) {
    Text(
        text = author,
        fontFamily = FontFamily.SansSerif,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.W200,
        fontStyle = FontStyle.Italic,
        color = SpacePrimaryVariant
    )
}

@Preview
@Composable
fun ExplanationButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = SpacePrimary)
    ) {
        Text(text = "Explanation")
    }
}

@Preview
@Composable
fun APODImageContainer(@PreviewParameter(StringParameterProvider::class) url: String) {
    Box(
        modifier = Modifier
            .border(1.dp, SpacePrimary, RoundedCornerShape(8.dp))
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 0.7f),
        contentAlignment = Alignment.Center,
    ) {
        APODImage(url = url)
    }
}

@Preview
@Composable
fun APODImage(@PreviewParameter(StringParameterProvider::class) url: String) {
    GlideImage(
        imageModel = url,
        contentDescription = "Daily Picture",
        contentScale = ContentScale.FillHeight,
        placeHolder = ImageVector.vectorResource(id = R.drawable.ic_baseline_image_24),
        error = ImageVector.vectorResource(id = R.drawable.ic_baseline_image_24),
        previewPlaceholder = R.drawable.ic_baseline_image_24,
        modifier = Modifier.clip(RoundedCornerShape(8.dp))
    )
}