package com.shehata.movies_kmp.user.di

import com.russhwolf.settings.ExperimentalSettingsApi
import com.shehata.movies_kmp.user.data.local.UserLocalDataSource
import com.shehata.movies_kmp.user.data.local.UserLocalDataSourceImpl
import com.shehata.movies_kmp.user.data.repository.UserRepository
import com.shehata.movies_kmp.user.domain.usecase.GetUserDataUseCase
import com.shehata.movies_kmp.user.domain.usecase.IsUserLoggedInUseCase
import com.shehata.movies_kmp.user.domain.usecase.SaveUserDataUseCase
import com.shehata.movies_kmp.user.domain.usecase.SetUserLoggedInUseCase
import org.koin.dsl.module


@OptIn(ExperimentalSettingsApi::class)
val userModule = module {
    // data
    single<UserLocalDataSource> { UserLocalDataSourceImpl() }
    single { UserRepository(get()) }

    // domain
    single { SetUserLoggedInUseCase(get()) }
    single { SaveUserDataUseCase(get()) }
    single { IsUserLoggedInUseCase(get()) }
    single { GetUserDataUseCase(get()) }
}