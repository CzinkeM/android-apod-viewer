package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    onExplanationClicked: () -> Unit,
    onFavoriteCheckedChanged: (checked: Boolean) -> Unit,
    onSharedIconClicked: () -> Unit
) {
    val checkedFavoriteButton = remember { mutableStateOf(false) }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconToggleButton(
            modifier = Modifier.weight(1f),
            checked = checkedFavoriteButton.value,
            onCheckedChange = { isChecked ->
                onFavoriteCheckedChanged(isChecked)
                checkedFavoriteButton.value = !checkedFavoriteButton.value
            }) {
            if (checkedFavoriteButton.value) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "description")
            } else {
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "description")
            }
        }

        ExplanationButton(
            modifier = Modifier.weight(1f),
            explanation = "test",
            onClick = {
                onExplanationClicked()
            })

        IconButton(
            modifier = Modifier.weight(1f),
            onClick = {
                onSharedIconClicked()
            }
        ) {
            Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
        }
    }
}