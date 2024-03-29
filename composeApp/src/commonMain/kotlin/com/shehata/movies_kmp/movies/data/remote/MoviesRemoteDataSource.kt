package com.shehata.movies_kmp.movies.data.remote

import com.shehata.movies_kmp.movies.data.model.MovieDataModel

interface MoviesRemoteDataSource {

    suspend fun getMovies(page: Int, pageSize: Int): List<MovieDataModel>
}