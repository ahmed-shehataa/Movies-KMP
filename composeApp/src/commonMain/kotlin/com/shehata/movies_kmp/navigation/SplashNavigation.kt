package com.shehata.movies_kmp.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorContent
import com.shehata.movies_kmp.splash.SplashScreen

private val splashScreens = listOf(SplashScreen)

@Composable
fun SplashNavigator(content: NavigatorContent = { CurrentScreen() }) =
    Navigator(
        screens = splashScreens,
        content = content
    )