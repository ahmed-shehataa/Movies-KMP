package com.shehata.movies_kmp.movies.data.retrofit.service

import com.shehata.movies_kmp.movies.data.retrofit.response.MoviesResponse

interface MoviesService {

    companion object Create {
        fun get(): MoviesService {
            return object : MoviesService {
                override suspend fun getMovies(): MoviesResponse {
                    return MoviesResponse(
                        page = 1,
                        movies = emptyList(),
                        totalPages = null,
                        totalResults = null
                    )
                }

            }
        }
    }

    //@GET("movie/popular")
    //@Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYTE1MjI0MzU1NjBmOThlN2Y2MmJmOGZhZDVkMGU1YyIsInN1YiI6IjYzNDZjMGMwZDU1YzNkMDA5MWI2MjU4MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.UGdd_xct65byKUEfXDYX2F3Z7Pw4aypXyRbSQputwH0")
    suspend fun getMovies(): MoviesResponse
}