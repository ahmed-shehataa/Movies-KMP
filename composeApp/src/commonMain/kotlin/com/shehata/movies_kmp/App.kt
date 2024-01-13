package com.shehata.movies_kmp

import androidx.compose.runtime.Composable
import com.shehata.movies_kmp.navigation.AuthNavigator
import com.shehata.movies_kmp.navigation.HomeNavigator
import com.shehata.movies_kmp.navigation.SplashNavigator
import com.shehata.movies_kmp.util.compose.MyScaffold
import com.shehata.movies_kmp.util.logging.initNapier


@Composable
fun App() {
    // Setup
    initNapier()

    // Navigation
    SplashNavigator {
        MyScaffold()
        AuthNavigator {}
        HomeNavigator {}
    }
}