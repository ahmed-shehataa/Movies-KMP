package com.shehata.movies_kmp.movies.presentation.model

import com.shehata.movies_kmp.BuildKonfig
import com.shehata.movies_kmp.base.pagination.PaginatedItem


data class MovieUIModel(
    val adult: Boolean?,
    val backdropPath: String?,
    val genreIds: List<Int?>?,
    val id: Int?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?,
    // All available sizes from here: https://www.themoviedb.org/talk/53c11d4ec3a3684cf4006400
    val posterUrl: String = BuildKonfig.BASE_IMAGE_URL + "w500/" + posterPath,
    val backdropUrl: String = BuildKonfig.BASE_IMAGE_URL + "original/" + backdropPath,
    val voteRate: VoteRate = VoteRate.getRate(voteAverage ?: 0.0)
) : PaginatedItem {
    override fun getId(): Int = id ?: -1
}