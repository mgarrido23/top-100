package com.top100.app.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.White

private val LightColorPalette = lightColors(
    primary = DarkBlueGrey,
    primaryVariant = Grey,
    secondary = Blue,
    background = White,
    surface = White,
    onPrimary = White,
    onBackground = Dark,
    onSurface = Dark,
)

// TODO: [Theme] Set up a dark color palette when the Design team provide it
private val DarkColorPalette = LightColorPalette

@Composable
fun AppTheme(
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
        content = content,
    )
}
