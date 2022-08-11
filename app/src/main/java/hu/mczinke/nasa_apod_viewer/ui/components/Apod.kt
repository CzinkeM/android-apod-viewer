package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.mczinke.nasa_apod_viewer.ui.preview_parameter_providers.StringParameterProvider
import hu.mczinke.nasa_apod_viewer.ui.theme.RobotoCondensed
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor

@Preview
@Composable
fun ApodTitle(@PreviewParameter(StringParameterProvider::class) title: String) {
    Text(
        text = title,
        fontFamily = RobotoCondensed,
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.W400,
        color = SpacePrimaryVariant,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 8.dp, 8.dp, 4.dp)
    )
}

@Preview
@Composable
fun ApodExplanation(@PreviewParameter(StringParameterProvider::class) explanation: String) {
    Text(
        text = explanation,
        fontFamily = RobotoCondensed,
        fontSize = 16.sp,
        textAlign = TextAlign.Justify,
        fontWeight = FontWeight.Normal,
        color = SpacePrimaryVariant,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 8.dp, 8.dp, 4.dp)
    )
}

@Preview
@Composable
fun ApodAuthor(@PreviewParameter(StringParameterProvider::class) author: String) {
    Text(
        text = author,
        fontFamily = RobotoCondensed,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Light,
        color = SpacePrimaryVariant,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun ExplanationButton(@PreviewParameter(StringParameterProvider::class) explanation: String) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = VibrantColor),
            modifier = Modifier.align(Alignment.Center),
        ) {
            Text(text = "Explanation")
        }
    }

}