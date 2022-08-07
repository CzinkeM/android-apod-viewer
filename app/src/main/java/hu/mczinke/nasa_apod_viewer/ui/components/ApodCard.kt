package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.ui.theme.SpaceBlackVariant
import hu.mczinke.nasa_apod_viewer.viewmodels.DatabaseRelatedViewModel

@Composable
fun ApodCard(
    apod: Apod,
    allowAddToFavorite: Boolean,
    allowDeleteFromFavorite: Boolean,
    viewModel: DatabaseRelatedViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(8.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        viewModel.addApodToDatabase(apod)
                    }
                )
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
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                ApodSmallImage(apod = apod)
                if (allowAddToFavorite) {
                    FavoriteIcon(
                        apod = apod,
                        iconScale = 0.3f,
                        viewModel = viewModel,
                        modifier = Modifier.align(
                            Alignment.BottomStart
                        )
                    )
                }
            }

            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(2f)
            ) {
                Text(
                    text = apod.title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
                if (allowDeleteFromFavorite) {
                    DeleteIcon(
                        apod = apod,
                        viewModel = viewModel,
                        modifier = Modifier.align(
                            Alignment.BottomEnd
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DeleteIcon(apod: Apod, viewModel: DatabaseRelatedViewModel, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .clickable {
                viewModel.deleteApodFromDatabase(apod)
            },
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_remove),
        contentDescription = "Thrash can image."
    )
}