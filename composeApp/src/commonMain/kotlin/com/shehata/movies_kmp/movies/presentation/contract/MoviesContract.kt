package com.shehata.movies_kmp.movies.presentation.contract

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel


data class MoviesUIState(
    val moviesList: SnapshotStateList<MovieUIModel> = mutableStateListOf(),
    val moviesSliderList: SnapshotStateList<MovieUIModel> = mutableStateListOf(),
)

sealed class MoviesIntent {
    data class OnMovieClicked(val movieUIModel: MovieUIModel) : MoviesIntent()
}

sealed class MoviesAction {
    data class OpenMovieDetailsScreen(val movieUIModel: MovieUIModel) : MoviesAction()
}


