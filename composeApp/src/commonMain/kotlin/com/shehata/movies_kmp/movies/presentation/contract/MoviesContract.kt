package com.shehata.movies_kmp.movies.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel


data class MoviesUIState(
    val isRefreshing: MutableState<Boolean> = mutableStateOf(false),
    //val networkError: MutableState<NetworkError?> = mutableStateOf(null),
    val moviesList: SnapshotStateList<MovieUIModel> = mutableStateListOf(),
    val moviesSliderList: SnapshotStateList<MovieUIModel> = mutableStateListOf(),
)

sealed class MoviesIntent {
    object RefreshScreen : MoviesIntent()
}

sealed class MoviesAction {
    object OpenMovieDetailsScreen : MoviesAction()
}


