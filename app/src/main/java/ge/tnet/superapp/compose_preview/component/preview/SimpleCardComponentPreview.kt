package ge.tnet.superapp.compose_preview.component.preview

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import ge.tnet.superapp.compose_preview.component.SimpleCardComponent
import ge.tnet.superapp.compose_preview.component.state.ProductData
import ge.tnet.superapp.compose_preview.previewAnnotations.DevicePreviews
import ge.tnet.superapp.compose_preview.previewAnnotations.ThemePreviews
import ge.tnet.superapp.compose_preview.ui.theme.ProvideAppTheme

class SimpleCardComponentPreviewParameterProvider :
    PreviewParameterProvider<ProductData> {
    override val values = sequenceOf(
        ProductData(
            title = "Heading",
            description = "This is a short description about a card.",
            imageSize = 200.dp,
            expand = true,
        ),
        ProductData(
            title = "Heading",
            description = "Subheading",
            imageSize = 48.dp,
            expand = false,
        ),
    )
}

@DevicePreviews
@ThemePreviews
@Composable
fun SimpleCardComponentPreview(
   @PreviewParameter(SimpleCardComponentPreviewParameterProvider::class) state: ProductData,
) {
    ProvideAppTheme {
        SimpleCardComponent(
            modifier = Modifier.padding(16.dp),
            state = state,
        )
    }
}
