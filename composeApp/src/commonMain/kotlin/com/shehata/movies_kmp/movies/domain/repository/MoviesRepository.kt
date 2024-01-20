package com.shehata.movies_kmp.movies.domain.repository

import com.shehata.movies_kmp.movies.domain.model.MovieDomainModel

interface MoviesRepository {

    suspend fun getMovies(page: Int, pageSize: Int): List<MovieDomainModel>
}