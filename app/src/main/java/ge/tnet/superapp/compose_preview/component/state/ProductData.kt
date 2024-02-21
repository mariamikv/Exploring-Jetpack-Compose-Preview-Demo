package ge.tnet.superapp.compose_preview.component.state

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

data class ProductData(
    val title: String,
    val description: String,
    val imageSize: Dp,
    val expand: Boolean,
)
