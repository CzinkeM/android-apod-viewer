package hu.mczinke.payment_manager.ui.components

import android.app.DatePickerDialog
import android.widget.DatePicker
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import hu.mczinke.payment_manager.models.Apod
import hu.mczinke.payment_manager.ui.theme.DimmedWhite
import hu.mczinke.payment_manager.ui.theme.SpaceBlackVariant
import hu.mczinke.payment_manager.ui.theme.SpacePrimaryVariant
import hu.mczinke.payment_manager.ui.theme.SpaceSecondary
import hu.mczinke.payment_manager.viewmodels.SearchViewModel
import java.util.*

@Composable
fun SearchScreen(viewModel: SearchViewModel) {
    val apods: List<Apod> by viewModel.apods.observeAsState(listOf(Apod.nullApod()))

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn() {
            item { SearchWidget() }
            items(items = apods) { apod ->
                Text(text = apod.title)
            }
        }
    }
}

@Composable
fun SearchWidget() {
    // TODO: Akkor igaz ha van választva dátum
    var disabledRange: Boolean = false
    var disabledDate: Boolean = false
    val showButton: Boolean = false

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

            specificDatePickerWidget(disabledDate)
            OrDivider()
            dateRangePickerWidget(disabledRange)
            if (showButton) {
                SearchButton()
            }
        }
    }
}

@Composable
fun specificDatePickerWidget(disable: Boolean): String {
    val context = LocalContext.current;
    val date = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                //todo: Should change on the button click as well
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Specific Date",
            color = dimColor(SpacePrimaryVariant, disable)
        )
        date.value = datePicker(buttonModifier = Modifier, buttonEnabled = !disable)
    }

    return date.value
}


@Composable
fun dateRangePickerWidget(disable: Boolean): Pair<String, String> {
    val startDate = remember { mutableStateOf("") }
    val endDate = remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Interval",
            color = dimColor(SpacePrimaryVariant, disable)
        )
        Box(modifier = Modifier.fillMaxWidth(0.7f)) {
            startDate.value =
                datePicker(buttonModifier = Modifier.align(Alignment.CenterStart), !disable)
            Divider(
                color = dimColor(SpacePrimaryVariant, disable),
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .padding(16.dp, 0.dp)
                    .align(Alignment.Center)
            )
            endDate.value =
                datePicker(buttonModifier = Modifier.align(Alignment.CenterEnd), !disable)
        }
    }

    return Pair(startDate.value, endDate.value)
}

@Composable
fun datePicker(buttonModifier: Modifier, buttonEnabled: Boolean): String {
    val context = LocalContext.current
    val year: Int
    val month: Int
    val day: Int
    val calendar = Calendar.getInstance()
    val buttonLabel = remember { mutableStateOf("Select") }

    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.time = Date()

    val date = remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, pickerYear: Int, pickerMonth: Int, pickerDay: Int ->
            date.value = "$pickerYear-${pickerMonth + 1}-$pickerDay"
        },
        year,
        month,
        day
    )
    datePickerDialog.setOnDateSetListener { _, yyyy, mm, dd ->
        date.value = "$yyyy-$mm-$dd"
        buttonLabel.value = date.value
    }

    datePickerDialog.setOnCancelListener {
        // TODO: make string static or const
        date.value = "cancelled"
        buttonLabel.value = date.value
    }
    datePickerDialog.datePicker.maxDate = calendar.time.time

    OutlinedButton(
        enabled = buttonEnabled,
        onClick = {
            datePickerDialog.show()
        },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primaryVariant,
            contentColor = MaterialTheme.colors.primary,
            disabledBackgroundColor = MaterialTheme.colors.primaryVariant.copy(.0f),
            disabledContentColor = MaterialTheme.colors.error.copy(.7f),
        ),
        modifier = buttonModifier
    ) {
        Text(text = buttonLabel.value, color = dimColor(DimmedWhite, !buttonEnabled))
    }
    return date.value
}

@Composable
fun SearchButton() {

    Button(
        shape = RoundedCornerShape(8.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = SpaceSecondary)
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