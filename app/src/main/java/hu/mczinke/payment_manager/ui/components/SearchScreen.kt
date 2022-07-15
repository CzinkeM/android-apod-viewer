package hu.mczinke.payment_manager.ui.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.mczinke.payment_manager.ui.theme.SpaceBlackVariant
import hu.mczinke.payment_manager.ui.theme.SpacePrimaryVariant
import java.util.*

@Composable
fun SearchScreen() {
    val testList = listOf("alma", "körte", "banán")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn() {
            item { SearchTitle() }
            items(items = testList) { label ->
                Text(text = label)
            }
        }
    }
}

@Composable
fun SearchTitle() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        backgroundColor = SpaceBlackVariant,
        elevation = 8.dp
    ) {
        Column {
            SpecificDatePickerWidget()
            OrDivider()
            DateRangePickerWidget()
        }
    }
    SearchBar()
}

@Composable
fun SpecificDatePickerWidget() {
    Column {
        Text(text = "Specific Date")
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("2002-02-07")
        }
    }
}

@Composable
fun OrDivider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Divider(
            color = SpacePrimaryVariant,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(8.dp, 0.dp)
                .align(Alignment.CenterStart)
        )
        Text(text = "OR", color = SpacePrimaryVariant, modifier = Modifier.align(Alignment.Center))
        Divider(
            color = SpacePrimaryVariant,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(8.dp, 0.dp)
                .align(Alignment.CenterEnd)
        )
    }
    /*
    Row(modifier = Modifier.fillMaxWidth(1f).padding(0.dp,8.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically ) {
        Divider(color = Color.Green, thickness = 1.dp, modifier = Modifier.padding(8.dp,0.dp))
        Text(text = "OR", color = Color.Red)
        Divider(color = Color.Red, thickness = 1.dp, modifier = Modifier.padding(8.dp,0.dp))
        //Divider(color = Color.Gray, thickness = 1.dp)
    }
     */
}

@Composable
fun DateRangePickerWidget() {
    Column() {
        Text(text = "Interval")
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("2002-02-07")
        }
    }
}

@Composable
fun SearchBar() {
    val mContext = LocalContext.current

    val mYear: Int
    val mMonth: Int
    val mDay: Int

    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    // Declaring a string value to
    // store date in string format
    val mDate = remember { mutableStateOf("") }

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )
    mDatePickerDialog.datePicker.maxDate = mCalendar.time.time

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Creating a button that on
        // click displays/shows the DatePickerDialog
        Button(onClick = {
            mDatePickerDialog.show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
            Text(text = "Open Date Picker", color = Color.White)
        }

        // Adding a space of 100dp height
        Divider(color = Color.Blue, thickness = 1.dp)

        // Displaying the mDate value in the Text
        Text(text = "Selected Date: ${mDate.value}", fontSize = 30.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun datePicker(): Date {
    return Date()
}