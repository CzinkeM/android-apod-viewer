package hu.mczinke.nasa_apod_viewer.ui.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.ui.theme.DimmedWhite
import hu.mczinke.nasa_apod_viewer.ui.theme.SpacePrimaryVariant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

//buttonModifier: Modifier, buttonEnabled: Boolean, minDate: Long = 0, maxDate: Date = Calendar.getInstance().time
@Composable
fun datePicker(
    modifier: Modifier = Modifier,
    minDateBounds: LocalDate? = null,
    maxDateBounds: LocalDate? = null,
): LocalDate {
    val minDateBoundsUsed = minDateBounds != null
    val maxDateBoundsUsed = maxDateBounds != null
    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-M-d", Locale.ENGLISH)
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val buttonLabelInit = stringResource(id = R.string.select)
    val buttonLabel = remember { mutableStateOf(buttonLabelInit) }
    val date = remember { mutableStateOf(LocalDate.now()) }
    val dateAsString = remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, pickerYear: Int, pickerMonth: Int, pickerDay: Int ->
            dateAsString.value = "$pickerYear-${pickerMonth + 1}-$pickerDay"
            date.value = LocalDate.parse(dateAsString.value, dateTimeFormatter)
            buttonLabel.value = dateAsString.value
        },
        if (maxDateBoundsUsed) {
            maxDateBounds!!.year
        } else {
            calendar.get(Calendar.YEAR)
        },
        if (maxDateBoundsUsed) {
            maxDateBounds!!.monthValue
        } else {
            calendar.get(Calendar.MONTH)
        },
        if (maxDateBoundsUsed) {
            maxDateBounds!!.dayOfMonth
        } else {
            calendar.get(Calendar.DAY_OF_MONTH)
        }
    )

    datePickerDialog.setOnCancelListener {
    }
    val minDate = if (minDateBoundsUsed) {
        Date.from(minDateBounds!!.atStartOfDay(ZoneId.systemDefault()).toInstant()).time
    } else {
        0
    }
    val maxDate = if (maxDateBoundsUsed) {
        Date.from(maxDateBounds!!.atStartOfDay(ZoneId.systemDefault()).toInstant()).time
    } else {
        calendar.time.time
    }
    DatePickerButton(buttonLabel = buttonLabel.value, onClick = {
        datePickerDialog.show()
    })

    datePickerDialog.datePicker.minDate = minDate
    datePickerDialog.datePicker.maxDate = maxDate // TODO: should change to maxbound


    return date.value
}

@Composable
fun DatePickerButton(buttonLabel: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier.fillMaxWidth(0.7f),
        onClick = {
            onClick()
        },
        border = if (buttonLabel == stringResource(id = R.string.select)) {
            BorderStroke(1.dp, SpacePrimaryVariant)
        } else {
            BorderStroke(1.dp, DimmedWhite)
        },
        shape = RoundedCornerShape(8.dp),
        colors = if (buttonLabel == stringResource(id = R.string.select)) {
            ButtonDefaults.outlinedButtonColors(contentColor = SpacePrimaryVariant)
        } else {
            ButtonDefaults.outlinedButtonColors(contentColor = DimmedWhite)
        }

    ) {
        Text(text = buttonLabel)
    }
}