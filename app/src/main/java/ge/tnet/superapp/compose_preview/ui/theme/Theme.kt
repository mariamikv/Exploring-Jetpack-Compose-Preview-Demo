package ge.tnet.superapp.compose_preview.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import ge.tnet.superapp.compose_preview.ui.colors.SuperColors
import ge.tnet.superapp.compose_preview.ui.colors.darkColors
import ge.tnet.superapp.compose_preview.ui.colors.lightColors

@Composable
fun ProvideAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkColors else lightColors
    
    CompositionLocalProvider(
        LocalColors provides colors,
        content = content
    )
}

object AppTheme {
    val colors: SuperColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
}

internal val LocalColors = staticCompositionLocalOf { SuperColors() }
