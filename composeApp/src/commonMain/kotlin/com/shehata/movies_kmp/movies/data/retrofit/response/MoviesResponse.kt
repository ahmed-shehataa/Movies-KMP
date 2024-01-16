package com.shehata.movies_kmp.movies.data.retrofit.response


import com.shehata.movies_kmp.movies.data.model.MovieDataModel

data class MoviesResponse(
    val page: Int?,
    val movies: List<MovieDataModel>?,
    val totalPages: Int?,
    val totalResults: Int?
)
