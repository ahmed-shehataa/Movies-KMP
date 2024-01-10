package app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import login.presentation.composables.LoginScreen

@Composable
fun App() {
    MaterialTheme {

        LoginScreen()

    }
}