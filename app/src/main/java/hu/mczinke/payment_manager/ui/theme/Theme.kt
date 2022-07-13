package hu.mczinke.payment_manager.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
        primary = SpacePrimary,
        primaryVariant = SpacePrimaryVariant,
        secondary = SpaceSecondary,
        surface = SpaceSecondary,
        background = SpaceBlack
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