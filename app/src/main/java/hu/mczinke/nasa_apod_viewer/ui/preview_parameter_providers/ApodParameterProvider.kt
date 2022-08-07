package hu.mczinke.nasa_apod_viewer.ui.preview_parameter_providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import hu.mczinke.nasa_apod_viewer.models.Apod

class ApodParameterProvider : PreviewParameterProvider<Apod> {
    override val values = sequenceOf(
        Apod.dummyApod()
    )
}