package hu.mczinke.nasa_apod_viewer.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import hu.mczinke.nasa_apod_viewer.R

// Set of Material typography styles to start with
val RobotoCondensed = FontFamily(
        Font(R.font.roboto_condensed_normal, FontWeight.Normal, FontStyle.Normal),
        Font(R.font.roboto_condensed_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.roboto_condensed_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.roboto_condensed_light, FontWeight.Light, FontStyle.Normal),
)

val Typography = Typography(
        body1 = TextStyle(
                fontFamily = RobotoCondensed,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        ),
        button = TextStyle(
                fontFamily = RobotoCondensed,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
        ),
        /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)