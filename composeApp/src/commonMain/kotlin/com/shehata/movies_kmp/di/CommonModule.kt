package com.shehata.movies_kmp.di

import com.shehata.movies_kmp.login.di.loginModule
import com.shehata.movies_kmp.movies.di.moviesModule
import com.shehata.movies_kmp.splash.di.splashModule
import com.shehata.movies_kmp.user.di.userModule
import org.koin.dsl.module


val commonModule = module {
    includes(
        singletonModule,
        userModule,
        loginModule,
        splashModule,
        moviesModule
    )
}