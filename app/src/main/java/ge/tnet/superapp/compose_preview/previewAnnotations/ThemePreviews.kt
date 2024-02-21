package ge.tnet.superapp.compose_preview.previewAnnotations

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "UI_MODE_NIGHT_NO",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "UI_MODE_NIGHT_YES",
    showBackground = true,
    backgroundColor = 0xFF212227,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class ThemePreviews
