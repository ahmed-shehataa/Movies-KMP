package com.shehata.movies_kmp.movies.presentation.screen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.remember
import cafe.adriel.voyager.koin.getScreenModel
import com.shehata.movies_kmp.base.BaseScreen
import com.shehata.movies_kmp.movies.presentation.composables.MoviesScreenContent
import com.shehata.movies_kmp.movies.presentation.contract.MoviesAction
import com.shehata.movies_kmp.movies.presentation.contract.MoviesIntent
import com.shehata.movies_kmp.movies.presentation.contract.MoviesUIState
import com.shehata.movies_kmp.movies.presentation.screenModel.MoviesScreenModel


@OptIn(ExperimentalMaterialApi::class)
object MoviesScreen : BaseScreen<MoviesUIState, MoviesIntent, MoviesAction>(
    model = { getScreenModel<MoviesScreenModel>() },
    content = { screenModel, uiState, snackBar ->

        val isRefreshing = remember { uiState.isRefreshing }

        val moviesList = remember { uiState.moviesList }

        val onRefresh = remember {
            {
                screenModel.setIntent(MoviesIntent.RefreshScreen)
            }
        }

        val isRefreshState = rememberPullRefreshState(
            refreshing = isRefreshing.value,
            onRefresh = onRefresh
        )

        MoviesScreenContent(
            isRefreshing = isRefreshing.value,
            isRefreshState = isRefreshState,
            moviesList = moviesList,
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