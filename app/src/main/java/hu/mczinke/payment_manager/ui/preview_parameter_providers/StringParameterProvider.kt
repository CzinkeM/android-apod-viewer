package hu.mczinke.payment_manager.ui.preview_parameter_providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class StringParameterProvider : PreviewParameterProvider<String> {
    override val values = sequenceOf("string mock")
}