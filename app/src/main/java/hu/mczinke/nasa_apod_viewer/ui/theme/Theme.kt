package hu.mczinke.nasa_apod_viewer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
        primary = SpaceBlue,
        secondary = DimmedWhite,
        surface = SpaceBlackVariant,
        background = SpaceBlackVariant,
        onSurface = DimmedWhite,
        onBackground = DimmedWhite,
        onPrimary = DimmedWhite,
        onSecondary = DimmedWhite
)

private val LightColorPalette = lightColors(
        primary = ElectricOrange,
        secondary = DimmedWhite,
        surface = DimmedWhite,
        background = DimmedWhite,
        onSurface = SpaceBlackVariant,
        onBackground = SpaceBlackVariant,
        onPrimary = SpaceBlackVariant,
        onSecondary = SpaceBlackVariant
)


@Composable
fun APODViewerTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
) {
        val colors = if (darkTheme) {
                DarkColorPalette
        } else {
                LightColorPalette
        }
        MaterialTheme(
                colors = colors,
                typography = Typography,
                shapes = Shapes,
                content = content
        )
}