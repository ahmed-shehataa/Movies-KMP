package com.shehata.movies_kmp.util.compose

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.compositionLocalOf

val LocalSnackBar = compositionLocalOf<SnackbarHostState>{
    error("No SnackBar Host State")
}