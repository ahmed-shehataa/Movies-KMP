package com.shehata.movies_kmp.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.shehata.movies_kmp.util.compose.LocalWindowSize

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes
    ) {
        CompositionLocalProvider(
            LocalWindowSize provides calculateWindowSizeClass().widthSizeClass
        ) {
            content()
        }
    }
}