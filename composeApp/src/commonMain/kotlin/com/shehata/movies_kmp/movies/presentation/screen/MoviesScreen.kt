package com.shehata.movies_kmp.movies.presentation.screen

import androidx.compose.runtime.remember
import cafe.adriel.voyager.koin.getScreenModel
import com.shehata.movies_kmp.base.screen.BaseScreen
import com.shehata.movies_kmp.movies.presentation.composables.MoviesScreenContent
import com.shehata.movies_kmp.movies.presentation.contract.MoviesAction
import com.shehata.movies_kmp.movies.presentation.contract.MoviesIntent
import com.shehata.movies_kmp.movies.presentation.contract.MoviesUIState
import com.shehata.movies_kmp.movies.presentation.screenModel.MoviesScreenModel


object MoviesScreen : BaseScreen<MoviesUIState, MoviesIntent, MoviesAction>(
    model = { getScreenModel<MoviesScreenModel>() },
    content = { screenModel, uiState, snackBar ->
        val moviesSliderList = remember { uiState.moviesSliderList }

        val onRefresh = remember {
            {
                screenModel.setIntent(MoviesIntent.RefreshScreen)
            }
        }

        MoviesScreenContent(
            pagingSource = (screenModel as MoviesScreenModel).moviesPagingSource,
            moviesSliderList = moviesSliderList,
            onTryAgain = {
                onRefresh()
            },
            onMovieClicked = {

            }
        )

    },

    onAction = { action, navigator ->
        when (action) {
            MoviesAction.OpenMovieDetailsScreen -> {

            }
        }
    }
)