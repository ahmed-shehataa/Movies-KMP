package com.shehata.movies_kmp.movies.di

import com.shehata.movies_kmp.AppDatabase
import com.shehata.movies_kmp.movies.data.ktor.service.MoviesService
import com.shehata.movies_kmp.movies.data.ktor.service.MoviesServiceImpl
import com.shehata.movies_kmp.movies.data.local.MoviesLocalDataSource
import com.shehata.movies_kmp.movies.data.local.MoviesLocalDataSourceImpl
import com.shehata.movies_kmp.movies.data.remote.MoviesRemoteDataSource
import com.shehata.movies_kmp.movies.data.remote.MoviesRemoteDataSourceImpl
import com.shehata.movies_kmp.movies.data.repository.MoviesRepositoryImpl
import com.shehata.movies_kmp.movies.domain.repository.MoviesRepository
import com.shehata.movies_kmp.movies.domain.usecase.GetMoviesListUseCase
import com.shehata.movies_kmp.movies.presentation.paging.MoviesPagingSource
import com.shehata.movies_kmp.movies.presentation.screenModel.MoviesScreenModel
import database.MoviesQueries
import org.koin.dsl.module


val moviesModule = module {
    // data
    factory<MoviesService> { MoviesServiceImpl(get()) }
    factory<MoviesQueries> { get<AppDatabase>().moviesQueries }
    factory<MoviesRemoteDataSource> { MoviesRemoteDataSourceImpl(get()) }
    factory<MoviesLocalDataSource> { MoviesLocalDataSourceImpl(get()) }
    factory<MoviesRepository> { MoviesRepositoryImpl(get(), get()) }
    factory { MoviesRepositoryImpl(get(), get()) }

    // domain
    factory { GetMoviesListUseCase(get()) }

    // ui
    factory { MoviesPagingSource(get()) }
    factory { MoviesScreenModel(get()) }
}