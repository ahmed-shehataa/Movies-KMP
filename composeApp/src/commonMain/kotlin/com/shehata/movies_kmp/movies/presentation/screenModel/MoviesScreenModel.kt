package com.shehata.movies_kmp.movies.presentation.screenModel

import cafe.adriel.voyager.core.model.screenModelScope
import com.shehata.movies_kmp.base.screenModel.BaseScreenModel
import com.shehata.movies_kmp.movies.presentation.contract.MoviesAction
import com.shehata.movies_kmp.movies.presentation.contract.MoviesIntent
import com.shehata.movies_kmp.movies.presentation.contract.MoviesUIState
import com.shehata.movies_kmp.movies.presentation.paging.MoviesPagingSource
import kotlinx.coroutines.launch


class MoviesScreenModel(
    val moviesPagingSource: MoviesPagingSource,
) : BaseScreenModel<MoviesUIState, MoviesIntent, MoviesAction>() {

    init {
        getMovies()
    }

    private fun getMovies() {
        screenModelScope.launch {
            moviesPagingSource.onFirstPageLoaded = { movies ->
                getUiState().moviesSliderList.clear()
                getUiState().moviesSliderList.addAll(movies.shuffled().take(5))
            }
        }
    }

    override fun createInitialState(): MoviesUIState = MoviesUIState()
    override suspend fun handleIntent(uiIntent: MoviesIntent) {
        when (uiIntent) {
            is MoviesIntent.OnMovieClicked -> {
                emitAction(MoviesAction.OpenMovieDetailsScreen(uiIntent.movieUIModel))
            }
        }
    }
}
