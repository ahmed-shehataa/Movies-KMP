package com.shehata.movies_kmp

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.shehata.movies_kmp.login.presentation.composables.LoginScreen
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

@Composable
fun App() {
    // TODO CALL IT JUST ONE TIME
    Napier.base(DebugAntilog())

    MaterialTheme {
        val snackBarHostState = remember { SnackbarHostState() }
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackBarHostState)
            },
        ) { contentPadding ->
            LoginScreen(snackBarHostState)
        }

    }
}