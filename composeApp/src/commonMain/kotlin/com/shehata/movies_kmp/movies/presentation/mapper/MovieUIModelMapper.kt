package com.shehata.movies_kmp.movies.presentation.mapper

import com.shehata.movies_kmp.movies.domain.model.MovieDomainModel
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel

fun MovieDomainModel.toUIModel() = MovieUIModel(
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