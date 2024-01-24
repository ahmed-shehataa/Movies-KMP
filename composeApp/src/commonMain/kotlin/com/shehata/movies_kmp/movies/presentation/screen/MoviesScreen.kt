package com.shehata.movies_kmp.movies.presentation.screen

import androidx.compose.runtime.remember
import cafe.adriel.voyager.koin.getScreenModel
import com.shehata.movies_kmp.base.screen.BaseScreen
import com.shehata.movies_kmp.movie_details.presentation.screen.MovieDetailsScreen
import com.shehata.movies_kmp.movies.presentation.composables.MoviesScreenContent
import com.shehata.movies_kmp.movies.presentation.contract.MoviesAction
import com.shehata.movies_kmp.movies.presentation.contract.MoviesIntent
import com.shehata.movies_kmp.movies.presentation.contract.MoviesUIState
import com.shehata.movies_kmp.movies.presentation.screenModel.MoviesScreenModel


object MoviesScreen : BaseScreen<MoviesUIState, MoviesIntent, MoviesAction>(
    model = { getScreenModel<MoviesScreenModel>() },
    content = { screenModel, uiState, snackBar ->
        val moviesSliderList = remember { uiState.moviesSliderList }

        MoviesScreenContent(
            pagingSource = (screenModel as MoviesScreenModel).moviesPagingSource,
            moviesSliderList = moviesSliderList,
            onMovieClicked = {
               screenModel.setIntent(MoviesIntent.OnMovieClicked(it))
            }
        )

    },

    onAction = { action, navigator ->
        when (action) {
            is MoviesAction.OpenMovieDetailsScreen -> {
                navigator.push(MovieDetailsScreen(action.movieUIModel))
            }
        }
    }
)