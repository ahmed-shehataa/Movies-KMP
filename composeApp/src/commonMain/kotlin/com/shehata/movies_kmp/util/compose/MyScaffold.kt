package com.shehata.movies_kmp.util.compose

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen

@Composable
fun MyScaffold(screen: Screen) {
    val snackBarHostState = remember { SnackbarHostState() }
    CompositionLocalProvider(
        values = arrayOf(
            LocalSnackBar provides snackBarHostState
        )
    ) {
        Scaffold(
            topBar = {  /*...*/ },
            content = { screen.Content() },
            bottomBar = {  /*...*/ },
            snackbarHost = {
                SnackbarHost(hostState = snackBarHostState)
            },
        )
    }
}
