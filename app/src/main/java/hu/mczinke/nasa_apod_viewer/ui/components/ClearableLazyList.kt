package hu.mczinke.nasa_apod_viewer.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.R
import hu.mczinke.nasa_apod_viewer.models.Apod
import hu.mczinke.nasa_apod_viewer.viewmodels.DatabaseRelatedViewModel

@Composable
fun CleanableLazyList(
    modifier: Modifier = Modifier,
    apods: List<Apod>,
    viewModel: DatabaseRelatedViewModel,
    onClearButtonClicked: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        LazyColumn {
            item { }
            items(items = apods) { apod ->
                ApodCard(
                    apod = apod,
                    allowDeleteFromFavorite = false,
                    allowAddToFavorite = true,
                    viewModel = viewModel
                )
            }
        }
        IconButton(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = {
                onClearButtonClicked()
            },
        ) {
            Icon(
                modifier = Modifier
                    .shadow(4.dp, CircleShape)
                    .alpha(0.4f),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_cancel),
                contentDescription = "Clear Button"
            )
        }

    }
}