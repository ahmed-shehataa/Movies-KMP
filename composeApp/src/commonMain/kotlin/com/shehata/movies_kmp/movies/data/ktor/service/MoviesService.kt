package com.shehata.movies_kmp.movies.data.ktor.service

import com.shehata.movies_kmp.movies.data.ktor.response.MoviesResponse

interface MoviesService {
    suspend fun getMovies(page: Int, pageSize: Int): MoviesResponse
}