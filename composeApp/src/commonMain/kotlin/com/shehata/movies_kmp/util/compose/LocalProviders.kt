package com.shehata.movies_kmp.util.compose

import androidx.compose.material.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.compositionLocalOf

val LocalWindowSize = compositionLocalOf { WindowWidthSizeClass.Compact }

val LocalSnackBar = compositionLocalOf<SnackbarHostState>{
    error("No SnackBar Host State")
}