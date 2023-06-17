package hu.mczinke.nasa_apod_viewer.home.presentation.screen

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.ui.components.ActionBar
import hu.mczinke.nasa_apod_viewer.ui.components.ApodBigImage
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant
import kotlinx.coroutines.launch

// TODO: constructor
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    val bottomSheetScaffoldState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
//    val apod: Apod by viewModel.apod.observeAsState(Apod.nullApod())
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier) {
//        HomeImageContainer(apod = apod)
        ActionBar(
            modifier = Modifier.fillMaxWidth(),
            onFavoriteCheckedChanged = { isChecked ->
                Log.d("action", "favorite checked: $isChecked")
            },
            onSharedIconClicked = {
                Log.d("action", "share dialog")
            },
            onExplanationClicked = {
                Log.d("action", "explanation clicked")
                coroutineScope.launch {
                    if (bottomSheetScaffoldState.isVisible) {
                        bottomSheetScaffoldState.hide()
                    } else {
                        bottomSheetScaffoldState.show()
                    }
                }
            }
        )
//        ApodTitle(apod.title)
//        ApodAuthor(
//            when (apod.copyright) {
//                "" -> ""
//                else -> apod.copyright
//            }
//        )
    }
}

@Composable
fun HomeImageContainer(apod: Apod) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, SpacePrimaryVariant, RoundedCornerShape(8.dp))
            .fillMaxHeight(0.7f)
            .fillMaxWidth(),
    ) {
        ApodBigImage(
            apod = apod,
            modifier = Modifier
                .align(Alignment.Center)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            //viewModel.addApodToDatabase(apod)
                        }
                    )
                },
        )
    }
}









