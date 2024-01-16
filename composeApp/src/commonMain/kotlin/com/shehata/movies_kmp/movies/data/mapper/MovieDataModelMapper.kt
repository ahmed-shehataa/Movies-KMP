package com.shehata.movies_kmp.movies.data.mapper

import com.shehata.movies_kmp.movies.data.model.MovieDataModel
import com.shehata.movies_kmp.movies.domain.model.MovieDomainModel

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