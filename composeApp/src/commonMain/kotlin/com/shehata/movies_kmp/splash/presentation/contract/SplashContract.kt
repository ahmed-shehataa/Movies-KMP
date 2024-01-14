package com.shehata.movies_kmp.splash.presentation.contract



sealed interface SplashAction {
    object OpenMoviesScreen : SplashAction
    object OpenLoginScreen : SplashAction
}