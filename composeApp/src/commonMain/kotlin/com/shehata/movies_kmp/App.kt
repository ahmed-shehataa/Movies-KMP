package com.shehata.movies_kmp

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.shehata.movies_kmp.splash.presentation.screen.SplashScreen
import com.shehata.movies_kmp.util.compose.MyScaffold
import com.shehata.movies_kmp.util.logging.initNapier


@Composable
fun App() {
    initNapier()

    Navigator(SplashScreen) {
        MyScaffold()
    }
}