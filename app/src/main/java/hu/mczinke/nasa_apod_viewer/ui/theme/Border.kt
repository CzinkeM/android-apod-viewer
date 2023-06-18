package hu.mczinke.nasa_apod_viewer.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun defaultBorderStroke() = BorderStroke(2.dp, MaterialTheme.colors.primary)

@Composable
fun thinBorderStroke() = BorderStroke(1.dp, MaterialTheme.colors.primary)

@Composable
fun thickBorderStroke() = BorderStroke(4.dp, MaterialTheme.colors.primary)