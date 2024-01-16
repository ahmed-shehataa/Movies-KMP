package com.shehata.movies_kmp.movies.data.remote

import com.shehata.movies_kmp.movies.data.model.MovieDataModel
import com.shehata.movies_kmp.movies.data.retrofit.service.MoviesService

class MoviesRemoteDataSourceImpl(
    private val service: MoviesService
) : MoviesRemoteDataSource {

    override suspend fun getMovies(): List<MovieDataModel> {
        return List(20) {
            MovieDataModel(
                adult = null,
                backdropPath = null,
                genreIds = listOf(),
                id = null,
                originalLanguage = null,
                originalTitle = null,
                overview = null,
                popularity = null,
                posterPath = null,
                releaseDate = null,
                title = "title",
                video = null,
                voteAverage = null,
                voteCount = null
            )
        }
        return service.getMovies().movies ?: emptyList()
    }
}