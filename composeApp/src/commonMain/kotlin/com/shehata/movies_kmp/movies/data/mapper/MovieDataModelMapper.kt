package com.shehata.movies_kmp.movies.data.mapper

import com.shehata.movies_kmp.movies.data.model.MovieDataModel
import com.shehata.movies_kmp.movies.domain.model.MovieDomainModel
import database.Movies

fun MovieDataModel.toDomainModel() = MovieDomainModel(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    id = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun Movies.toDataModel(): MovieDataModel {
    return MovieDataModel(
        id = id.toInt(),
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds.toIntListOrNull(),
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount?.toInt()
    )
}

fun List<Int?>?.toStringOrNull(): String {
    return this?.filterNotNull()?.joinToString(", ") ?: "null"
}

fun String?.toIntListOrNull(): List<Int?>? {
    return this?.split(",")?.map { it.trim().toIntOrNull() }
}