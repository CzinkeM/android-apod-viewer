package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.ui.preview_parameter_providers.StringParameterProvider
import hu.mczinke.nasa_apod_viewer.ui.theme.RobotoCondensed
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor
import hu.mczinke.nasa_apod_viewer.viewmodels.HomeViewModel


@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val apod: Apod by viewModel.apod.observeAsState(Apod.nullApod())

    Column {
        HomeImageContainer(apod = apod, viewModel = viewModel)
        ApodTitle(apod.title)
        ApodAuthor(
            when (apod.copyright) {
                "" -> ""
                else -> apod.copyright
            }
        )
        ExplanationButton(apod.explanation)
    }
}

@Composable
fun HomeImageContainer(apod: Apod, viewModel: HomeViewModel) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, SpacePrimaryVariant, RoundedCornerShape(8.dp))
            .fillMaxHeight(0.7f)
            .fillMaxWidth(),
    ) {
        ApodBigImageWithFavoriteIcon(
            apod = apod,
            viewModel = viewModel,
            modifier = Modifier
                .align(Alignment.Center)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            viewModel.addApodToDatabase(apod)
                        }
                    )
                },
        )
    }
}

@Preview
@Composable
fun ApodTitle(@PreviewParameter(StringParameterProvider::class) title: String) {
    Text(
        text = title,
        fontFamily = FontFamily.SansSerif,
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

@Composable
fun ExplanationModalDrawer(explanation: String) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            Text(text = explanation)
        }
    ) {}
}





