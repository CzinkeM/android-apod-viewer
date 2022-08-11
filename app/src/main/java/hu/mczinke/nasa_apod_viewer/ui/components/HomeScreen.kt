package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant
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









