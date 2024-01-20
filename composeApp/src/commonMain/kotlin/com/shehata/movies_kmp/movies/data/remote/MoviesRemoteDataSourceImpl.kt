package com.shehata.movies_kmp.movies.data.remote

import com.shehata.movies_kmp.movies.data.ktor.service.MoviesService
import com.shehata.movies_kmp.movies.data.model.MovieDataModel

class MoviesRemoteDataSourceImpl(
    private val service: MoviesService
) : MoviesRemoteDataSource {

    override suspend fun getMovies(page: Int, pageSize: Int): List<MovieDataModel> {
        return service.getMovies(page, pageSize).movies ?: emptyList()
    }
}