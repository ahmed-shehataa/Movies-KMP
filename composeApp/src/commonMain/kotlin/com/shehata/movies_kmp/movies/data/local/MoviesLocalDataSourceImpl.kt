package com.shehata.movies_kmp.movies.data.local

import com.shehata.movies_kmp.movies.data.mapper.toDataModel
import com.shehata.movies_kmp.movies.data.mapper.toStringOrNull
import com.shehata.movies_kmp.movies.data.model.MovieDataModel
import database.MoviesQueries

class MoviesLocalDataSourceImpl(
    private val moviesQueries: MoviesQueries,
) : MoviesLocalDataSource {

    override suspend fun getMovies(page: Int, pageSize: Int): List<MovieDataModel> {
        return moviesQueries
            .getMovies(page = page.toLong(), size = pageSize.toLong())
            .executeAsList()
            .map {
                it.toDataModel()
            }
    }

    override suspend fun insertMovies(list: List<MovieDataModel>) {
        list.forEach {
            with(it) {
                moviesQueries.insertMovie(
                    adult = adult,
                    backdropPath = backdropPath,
                    genreIds = genreIds.toStringOrNull(),
                    originalLanguage = originalLanguage,
                    originalTitle = originalTitle,
                    overview = overview,
                    popularity = popularity,
                    posterPath = posterPath,
                    releaseDate = releaseDate,
                    title = title,
                    video = video,
                    voteAverage = voteAverage,
                    voteCount = voteCount?.toLong()
                )
            }
        }
    }

    override suspend fun clearAll() {
        moviesQueries.clearMovies()
    }
}

