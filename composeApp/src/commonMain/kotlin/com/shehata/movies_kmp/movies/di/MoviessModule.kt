package com.shehata.movies_kmp.movies.di

import com.shehata.movies_kmp.movies.data.remote.MoviesRemoteDataSource
import com.shehata.movies_kmp.movies.data.remote.MoviesRemoteDataSourceImpl
import com.shehata.movies_kmp.movies.data.repository.MoviesRepositoryImpl
import com.shehata.movies_kmp.movies.data.retrofit.service.MoviesService
import com.shehata.movies_kmp.movies.domain.repository.MoviesRepository
import com.shehata.movies_kmp.movies.domain.usecase.GetMoviesListUseCase
import com.shehata.movies_kmp.movies.presentation.screenModel.MoviesScreenModel
import org.koin.dsl.module


val moviesModule = module {
    // data
    single<MoviesService> { MoviesService.get() }
    single<MoviesRemoteDataSource> { MoviesRemoteDataSourceImpl(get()) }
    single<MoviesRepository> { MoviesRepositoryImpl(get()) }
    single { MoviesRepositoryImpl(get()) }

    // domain
    single { GetMoviesListUseCase(get()) }

    // ui
    factory { MoviesScreenModel(get()) }
}