package hu.mczinke.nasa_apod_viewer.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.models.DateFilter
import hu.mczinke.nasa_apod_viewer.ui.theme.DimmedWhite
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor
import hu.mczinke.nasa_apod_viewer.viewmodels.SearchViewModel
import java.time.LocalDate

@Composable
fun SearchScreen(viewModel: SearchViewModel) {
    val apods: List<Apod> by viewModel.apods.observeAsState(listOf())
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)

    val spaceShipComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.spaceship))
    val spaceShipProgress by animateLottieCompositionAsState(
        composition = spaceShipComposition,
        iterations = LottieConstants.IterateForever
    )

    val astronautComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.astronaut))
    val astronautProgress by animateLottieCompositionAsState(
        composition = astronautComposition,
        iterations = LottieConstants.IterateForever
    )

    if (apods.isEmpty() || isLoading) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LottieAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
                    .padding(8.dp),
                composition = if (isLoading) {
                    spaceShipComposition
                } else {
                    astronautComposition
                },
                progress = if (isLoading) {
                    spaceShipProgress
                } else {
                    astronautProgress
                },
            )
            if (!isLoading) {
                Text(
                    text = "Nothing to show",
                    color = DimmedWhite
                )
            }
        }

    } else {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            LazyColumn {
                item { }
                items(items = apods) { apod ->
                    ApodCard(
                        apod = apod,
                        allowDeleteFromFavorite = false,
                        allowAddToFavorite = true,
                        viewModel = viewModel
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun dateRangePickerWidget(): DateFilter {
    val startDate = remember { mutableStateOf(LocalDate.now()) }
    val endDate = remember { mutableStateOf(LocalDate.now()) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Log.d("Click", "Period Date Clicked")
            }
    ) {
        Text(
            text = "From:",
            color = SpacePrimaryVariant
        )
        startDate.value = datePicker(
            modifier = Modifier
                .weight(1f),
            maxDateBounds = endDate.value,
        )
        Text(
            text = "To:",
            color = SpacePrimaryVariant
        )
        endDate.value = datePicker(
            modifier = Modifier
                .weight(1f),
            minDateBounds = startDate.value
        )
    }
    return DateFilter(startDate.value, endDate.value)
}


@Composable
fun SearchButton(modifier: Modifier = Modifier, onClick: () -> Unit, enabled: Boolean = true) {

    Button(
        modifier = modifier.fillMaxWidth(0.5f),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = VibrantColor),
        enabled = enabled
    ) {
        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
    }
}