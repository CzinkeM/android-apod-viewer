package hu.mczinke.nasa_apod_viewer.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
        primary = SpacePrimaryVariant,
        primaryVariant = SpacePrimaryVariant,
        secondary = DimmedWhite,
        surface = SpaceBlackVariant,
        background = SpaceBlack,
)

@Composable
fun APODViewerTheme(content: @Composable () -> Unit) {
        MaterialTheme(
                colors = DarkColorPalette,
                typography = Typography,
                shapes = Shapes,
                content = content
        )
}