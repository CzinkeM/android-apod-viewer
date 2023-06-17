package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.models.DateFilter
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor
import hu.mczinke.nasa_apod_viewer.viewmodels.SearchViewModel

@Composable
fun SearchFloatingActionButton(
    modifier: Modifier = Modifier,
//    viewModel: SearchViewModel
) {
    // TODO:  
    val openDialog = remember { mutableStateOf(false) }
    val enabledSearchButton = remember { mutableStateOf(true) }
    val dateFilter by remember { mutableStateOf(DateFilter()) }

    FloatingActionButton(
        onClick = { openDialog.value = !openDialog.value },
        shape = RoundedCornerShape(8.dp),
        backgroundColor = VibrantColor
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Floating Action Button"
        )
    }
    if (openDialog.value) {
        AlertDialog(
            shape = RoundedCornerShape(8.dp),
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Select Date")
            },
            text = {
                Column {
                    val pickedDateFilter = dateRangePickerWidget()
                    dateFilter.startDate = pickedDateFilter.startDate
                    dateFilter.endDate = pickedDateFilter.endDate
                }
            },
            buttons = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    SearchButton(
                        modifier = Modifier.align(CenterHorizontally),
                        enabled = enabledSearchButton.value,
                        onClick = {
                            // TODO:  
//                            viewModel.getApodsInPeriod(dateFilter)
                            openDialog.value = false
                        })
                    TextButton(
                        modifier = Modifier.fillMaxWidth(0.3f),
                        onClick = { openDialog.value = false }
                    ) {
                        Text("Cancel")
                    }
                }
            }
        )
    }
}