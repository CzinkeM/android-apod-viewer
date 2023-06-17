package hu.mczinke.nasa_apod_viewer.home.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.home.presentation.HomeViewModel
import hu.mczinke.nasa_apod_viewer.home.presentation.component.MediaContainer
import hu.mczinke.nasa_apod_viewer.ui.components.ActionBar
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

// TODO: constructor
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val bottomSheetScaffoldState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val apod by viewModel.apod.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier.fillMaxSize()) {
        MediaContainer(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            apod = apod,
        )
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

//@Composable
//fun HomeImageContainer(apod: Apod) {
//    Box(
//        modifier = Modifier
//            .padding(8.dp)
//            .border(1.dp, SpacePrimaryVariant, RoundedCornerShape(8.dp))
//            .fillMaxHeight(0.7f)
//            .fillMaxWidth(),
//    ) {
//        ApodBigImage(
//            apod = apod,
//            modifier = Modifier
//                .align(Alignment.Center)
//                .pointerInput(Unit) {
//                    detectTapGestures(
//                        onDoubleTap = {
//                            //viewModel.addApodToDatabase(apod)
//                        }
//                    )
//                },
//        )
//    }
//}









