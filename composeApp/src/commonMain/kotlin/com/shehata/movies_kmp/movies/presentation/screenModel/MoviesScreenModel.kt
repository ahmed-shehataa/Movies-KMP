package com.shehata.movies_kmp.movies.presentation.screenModel

import cafe.adriel.voyager.core.model.screenModelScope
import com.shehata.movies_kmp.base.BaseScreenModel
import com.shehata.movies_kmp.movies.domain.usecase.GetMoviesListUseCase
import com.shehata.movies_kmp.movies.presentation.contract.MoviesAction
import com.shehata.movies_kmp.movies.presentation.contract.MoviesIntent
import com.shehata.movies_kmp.movies.presentation.contract.MoviesUIState
import com.shehata.movies_kmp.movies.presentation.mapper.toUIModel
import kotlinx.coroutines.launch


class MoviesScreenModel(
    private val getMoviesListUseCase: GetMoviesListUseCase
) : BaseScreenModel<MoviesUIState, MoviesIntent, MoviesAction>() {

    init {
        getMovies()
    }

    private fun getMovies() {
        screenModelScope.launch {
            val movies = getMoviesListUseCase.execute(
                page = 1,
                pageSize = 20
            ).map { it.toUIModel() }
            getUiState().moviesList.addAll(movies)
        }
    }

    override fun createInitialState(): MoviesUIState = MoviesUIState()
    override suspend fun handleIntent(uiIntent: MoviesIntent) {
        when (uiIntent) {
            MoviesIntent.RefreshScreen -> {

            }
        }
    }
}
