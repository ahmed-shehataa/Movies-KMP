package com.shehata.movies_kmp.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.shehata.movies_kmp.util.compose.LocalDimen
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
            val windowSize = LocalWindowSize.current
            val dimen = remember(windowSize) {
                when (windowSize) {
                    WindowWidthSizeClass.Compact -> { CompactDimen() }
                    WindowWidthSizeClass.Medium -> { MediumDimen() }
                    WindowWidthSizeClass.Expanded -> { ExpandedDimen() }
                    else -> { CompactDimen() }
                }
            }
            CompositionLocalProvider(LocalDimen provides dimen) {
                content()
            }
        }
    }
}