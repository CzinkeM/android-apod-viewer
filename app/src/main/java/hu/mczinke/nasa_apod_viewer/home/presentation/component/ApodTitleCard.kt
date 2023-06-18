package hu.mczinke.nasa_apod_viewer.home.presentation.component

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.ui.theme.VibrantColor

@Composable
fun ApodTitleCard(
    modifier: Modifier = Modifier,
    apod: Apod?
) {
    if(apod == null) {
        Spacer(modifier = modifier)
    }else {
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(8.dp),
            elevation = 0.dp,
            border = BorderStroke(2.dp, VibrantColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            ){
                Text(
                    modifier = Modifier.align(Alignment.Center).fillMaxWidth(),
                    text = constructApodTitle(apod.title, apod.copyright),
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

private fun constructApodTitle(title: String, copyright: String?): String {
    val copyrightWithoutLineBreak = copyright?.replace("\n"," ")
    return when {
        title.isEmpty() && copyright.isNullOrEmpty() -> {
            "Unknown"
        }
        title.isEmpty() && !copyright.isNullOrEmpty() -> {
            "Copyright: $copyright"
        }
        title.isNotEmpty() && copyright.isNullOrEmpty() -> {
            "$title by unknown"
        }
        title.isNotEmpty() && !copyright.isNullOrEmpty() -> {
            "$title\n" +
            "(copyright: $copyrightWithoutLineBreak)"
        }
        else -> {
            "Else branch."
        }
    }
}