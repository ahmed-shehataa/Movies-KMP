package com.shehata.movies_kmp.movies.data.repository

import com.shehata.movies_kmp.movies.domain.model.MovieDomainModel
import com.shehata.movies_kmp.movies.domain.repository.MoviesRepository
import com.shehata.movies_kmp.movies.data.mapper.toDomainModel
import com.shehata.movies_kmp.movies.data.remote.MoviesRemoteDataSource


class MoviesRepositoryImpl(
    private val remote: MoviesRemoteDataSource,
) : MoviesRepository {


    override suspend fun getMovies(): List<MovieDomainModel> {
        return remote.getMovies().map { it.toDomainModel() }
    }


}