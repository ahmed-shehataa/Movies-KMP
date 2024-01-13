package com.shehata.movies_kmp

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.shehata.movies_kmp.login.presentation.screen.LoginScreen
import com.shehata.movies_kmp.util.compose.LocalSnackBar
import com.shehata.movies_kmp.util.logging.initNapier


@Composable
fun App() {
    // Setup
    initNapier()

    // Navigation
    Navigator(LoginScreen) { navigator ->
        val snackBarHostState = remember { SnackbarHostState() }
        CompositionLocalProvider( values = arrayOf(
            LocalSnackBar provides snackBarHostState
        )) {
            Scaffold(
                topBar = { /* ... */ },
                content = { CurrentScreen() },
                bottomBar = { /* ... */ },
                snackbarHost = {
                    SnackbarHost(hostState = snackBarHostState)
                },
            )
        }
    }
}