package com.shehata.movies_kmp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.shehata.movies_kmp.login.presentation.composables.LoginScreen
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

@Composable
fun App() {
    // TODO CALL IT JUST ONE TIME
    Napier.base(DebugAntilog())

    MaterialTheme {
        LoginScreen()
    }
}