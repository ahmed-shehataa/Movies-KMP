package com.shehata.movies_kmp.di

import com.shehata.movies_kmp.login.presentation.viewModel.LoginViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual class PlatformModule {
    actual val module: Module = module {

        factory { LoginViewModel(get()) }
    }
}