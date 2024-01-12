package com.shehata.movies_kmp.di

import com.shehata.movies_kmp.login.di.loginModule
import com.shehata.movies_kmp.user.di.userModule
import org.koin.core.module.Module
import org.koin.dsl.module

expect class PlatformModule {
    val module: Module
}

val commonModule = module {
    includes(userModule, loginModule)
}