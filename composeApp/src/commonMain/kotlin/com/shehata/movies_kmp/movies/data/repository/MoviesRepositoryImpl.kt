package com.shehata.movies_kmp.movies.data.repository

import com.shehata.movies_kmp.movies.data.local.MoviesLocalDataSource
import com.shehata.movies_kmp.movies.data.mapper.toDomainModel
import com.shehata.movies_kmp.movies.data.remote.MoviesRemoteDataSource
import com.shehata.movies_kmp.movies.domain.model.MovieDomainModel
import com.shehata.movies_kmp.movies.domain.repository.MoviesRepository


class MoviesRepositoryImpl(
    private val local: MoviesLocalDataSource,
    private val remote: MoviesRemoteDataSource,
) : MoviesRepository {


    override suspend fun getMovies(page: Int, pageSize: Int): List<MovieDomainModel> {
        val localMovies = local.getMovies(page, pageSize).map { it.toDomainModel() }

        if (localMovies.isEmpty()) {
            val remoteMovies = remote.getMovies(page, pageSize)
            local.insertMovies(remoteMovies)
        }

        return local.getMovies(page, pageSize).map { it.toDomainModel() }
    }


}