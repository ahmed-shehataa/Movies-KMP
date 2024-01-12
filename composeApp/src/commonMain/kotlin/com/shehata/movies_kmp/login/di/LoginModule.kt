package com.shehata.movies_kmp.login.di

import com.shehata.movies_kmp.login.data.remote.LoginRemoteDataSource
import com.shehata.movies_kmp.login.data.remote.LoginRemoteDataSourceImpl
import com.shehata.movies_kmp.login.data.repository.LoginRepository
import com.shehata.movies_kmp.login.domain.LoginByEmailUseCase
import org.koin.dsl.module


val loginModule = module {
    // data
    single<LoginRemoteDataSource> { LoginRemoteDataSourceImpl() }
    single { LoginRepository(get()) }

    // domain
    single { LoginByEmailUseCase(get()) }
}