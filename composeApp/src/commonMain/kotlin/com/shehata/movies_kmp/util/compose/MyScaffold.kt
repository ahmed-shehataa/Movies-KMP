package com.shehata.movies_kmp.util.compose

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.CurrentScreen

@Composable
fun MyScaffold() {
    val snackBarHostState = remember { SnackbarHostState() }
    CompositionLocalProvider(
        values = arrayOf(
            LocalSnackBar provides snackBarHostState
        )
    ) {
        Scaffold(
            topBar = {  /*...*/ },
            content = { CurrentScreen() },
            bottomBar = {  /*...*/ },
            snackbarHost = {
                SnackbarHost(hostState = snackBarHostState)
            },
        )
    }
}
