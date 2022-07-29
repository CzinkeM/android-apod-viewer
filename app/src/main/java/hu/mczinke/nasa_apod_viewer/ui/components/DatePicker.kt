package hu.mczinke.nasa_apod_viewer.ui.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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

    val buttonLabel = remember { mutableStateOf("Select") }
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

    datePickerDialog.datePicker.minDate = minDate
    datePickerDialog.datePicker.maxDate = maxDate // TODO: should change to maxbound

    OutlinedButton(
        onClick = {
            datePickerDialog.show()
        },
        border = BorderStroke(1.dp, SpacePrimaryVariant),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = SpacePrimaryVariant)
    ) {
        Text(text = buttonLabel.value)
    }
    return date.value
}