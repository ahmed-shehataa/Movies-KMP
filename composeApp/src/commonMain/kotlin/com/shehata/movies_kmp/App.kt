package com.shehata.movies_kmp

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScaleTransition
import com.shehata.movies_kmp.splash.presentation.screen.SplashScreen
import com.shehata.movies_kmp.theme.AppTheme
import com.shehata.movies_kmp.util.coil.initCoil
import com.shehata.movies_kmp.util.compose.AppScaffold
import com.shehata.movies_kmp.util.logging.initNapier

@Composable
fun App() {
    initCoil()
    initNapier()

    AppTheme {
        Navigator(SplashScreen) { navigator ->
            ScaleTransition(navigator) { screen ->
                AppScaffold(screen)
            }
        }
    }

}