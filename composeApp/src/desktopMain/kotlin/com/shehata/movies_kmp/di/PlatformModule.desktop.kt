package com.shehata.movies_kmp.di

import com.shehata.movies_kmp.data.local.DriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module


actual val platformModule: Module = module {
    single { DriverFactory() }
}