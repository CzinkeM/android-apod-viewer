package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = Icons.Default.Download.name
                )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.ExpandMore,
                    contentDescription = Icons.Default.ExpandMore.name
                )
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = Icons.Default.Share.name
                )
            }
        }
    }
}