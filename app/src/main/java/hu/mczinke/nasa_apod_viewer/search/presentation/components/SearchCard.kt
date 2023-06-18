package hu.mczinke.nasa_apod_viewer.search.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import hu.mczinke.nasa_apod_viewer.search.domain.SearchTab
import hu.mczinke.nasa_apod_viewer.search.presentation.SearchViewModel
import hu.mczinke.nasa_apod_viewer.ui.theme.defaultBorderStroke
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchCard(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = koinViewModel()
) {
    var selectedTab by remember {
        mutableStateOf(SearchTab.SPECIFIC)
    }

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        border = defaultBorderStroke(),
        elevation = 0.dp
    ) {
        Column(modifier = Modifier) {
            Row(modifier = Modifier
                .fillMaxHeight(.25f)
                .fillMaxWidth()) {

                TextButton(
                    onClick = {
                        selectedTab = SearchTab.SPECIFIC
                    }
                ) {
                    Text(text = "Specific date")
                }
                TextButton(
                    onClick = {
                        selectedTab = SearchTab.RANGE
                    }
                ) {
                    Text(text = "Range")
                }
            }
            AnimatedContent(targetState = selectedTab) {
                when(selectedTab) {
                    SearchTab.SPECIFIC -> SearchSpecific(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    )
                    SearchTab.RANGE -> SearchRange(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    )
                }
            }
        }

    }
}