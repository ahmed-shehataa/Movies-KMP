package com.shehata.movies_kmp.splash.di

import com.shehata.movies_kmp.splash.presentation.screenModel.SplashScreenModel
import org.koin.dsl.module


val splashModule = module {
    // ui
    factory { SplashScreenModel(get()) }
}