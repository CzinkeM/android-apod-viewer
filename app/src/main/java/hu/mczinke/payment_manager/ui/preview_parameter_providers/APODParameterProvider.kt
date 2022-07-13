package hu.mczinke.payment_manager.ui.preview_parameter_providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import hu.mczinke.payment_manager.models.APOD

class APODParameterProvider : PreviewParameterProvider<APOD> {
    override val values = sequenceOf(
        APOD(
            "copyright",
            "date",
            "explanation",
            "hdURL",
            "mediaType",
            "version",
            "title",
            "url"
        )
    )
}