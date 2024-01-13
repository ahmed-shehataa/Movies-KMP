package com.shehata.movies_kmp.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorContent
import com.shehata.movies_kmp.login.presentation.screen.LoginScreen

private val authScreens = listOf(LoginScreen)

@Composable
fun AuthNavigator(content: NavigatorContent = { CurrentScreen() }) =
    Navigator(
        screens = authScreens,
        content = content
    )