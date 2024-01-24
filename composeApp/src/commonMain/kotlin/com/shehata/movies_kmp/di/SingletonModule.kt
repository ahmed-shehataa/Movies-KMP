package com.shehata.movies_kmp.di

import com.shehata.movies_kmp.data.local.createDatabase
import com.shehata.movies_kmp.data.remote.getKtorClient
import org.koin.dsl.module

val singletonModule = module {
    single { getKtorClient() }
    single { createDatabase(get()) }
}