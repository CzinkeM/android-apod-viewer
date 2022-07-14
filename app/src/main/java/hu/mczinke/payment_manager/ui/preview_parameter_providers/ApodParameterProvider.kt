package hu.mczinke.payment_manager.ui.preview_parameter_providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import hu.mczinke.payment_manager.models.Apod

class ApodParameterProvider : PreviewParameterProvider<Apod> {
    override val values = sequenceOf(
        Apod(
            "copyright",
            "date",
            "explanation",
            "HDUrl",
            "title",
            "url",
        )
    )
}