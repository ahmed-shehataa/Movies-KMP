package com.shehata.movies_kmp.movies.data.ktor.response


import com.shehata.movies_kmp.movies.data.model.MovieDataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MoviesResponse(
    @SerialName("page")
    val page: Int?,
    @SerialName("results")
    val movies: List<MovieDataModel>?,
    @SerialName("total_pages")
    val totalPages: Int?,
    @SerialName("total_results")
    val totalResults: Int?
)
