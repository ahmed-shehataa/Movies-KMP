package com.shehata.movies_kmp.movies.data.local

import com.shehata.movies_kmp.movies.data.model.MovieDataModel

interface MoviesLocalDataSource {

    suspend fun getMovies(page: Int, pageSize: Int): List<MovieDataModel>
    suspend fun insertMovies(list: List<MovieDataModel>)
    suspend fun clearAll()
}