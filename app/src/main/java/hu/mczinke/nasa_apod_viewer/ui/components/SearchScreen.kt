package hu.mczinke.nasa_apod_viewer.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.models.DateFilter
import hu.mczinke.nasa_apod_viewer.ui.theme.SpaceBlackVariant
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor
import hu.mczinke.nasa_apod_viewer.viewmodels.SearchViewModel
import java.time.LocalDate


/*
    val parsedEndDate = LocalDate.parse(endDate.value, dateTimeFormatter)
    val endDateAsLong = Date.from(parsedEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant())

 */
@Composable
fun SearchScreen(viewModel: SearchViewModel) {
    val apods: List<Apod> by viewModel.apods.observeAsState(listOf(Apod.nullApod()))


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn {
            item { SearchWidget(viewModel) }
            items(items = apods) { apod ->
                ApodCard(apod = apod)
            }
        }
    }
}

@Composable
fun SearchWidget(searchViewModel: SearchViewModel) {
    val selectedDate = remember { DateFilter() }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        backgroundColor = SpaceBlackVariant,
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val data = dateRangePickerWidget()
            selectedDate.startDate = data.startDate
            selectedDate.endDate = data.endDate
            if (true) {
                SearchButton(selectedDate, searchViewModel)
            }
        }
    }
}

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
            text = "Interval",
            color = SpacePrimaryVariant
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            startDate.value = datePicker(
                modifier = Modifier
                    .weight(1f),
                maxDateBounds = endDate.value
            )
            endDate.value = datePicker(
                modifier = Modifier
                    .weight(1f),
                minDateBounds = startDate.value
            )
        }
    }
    return DateFilter(startDate.value, endDate.value)
}


@Composable
fun SearchButton(dateFilter: DateFilter, searchViewModel: SearchViewModel) {

    Button(
        shape = RoundedCornerShape(8.dp),
        onClick = {
            searchViewModel.getApodsInPeriod(dateFilter)
            /*
            if (dateFilter.isPeriod()) {

            } else {
                searchViewModel.getApodsAtSpecificDate(dateFilter)
            }
             */
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = VibrantColor)
    ) {
        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
    }
}

fun dimColor(color: Color, disable: Boolean): Color {
    //make use of default
    return if (disable) {
        color.copy(0.6f)
    } else {
        color
    }
}