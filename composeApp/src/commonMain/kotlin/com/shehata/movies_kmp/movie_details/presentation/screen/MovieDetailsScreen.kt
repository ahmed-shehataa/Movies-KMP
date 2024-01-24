package com.shehata.movies_kmp.movie_details.presentation.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shehata.movies_kmp.movie_details.presentation.composables.MovieDetailsScreenContent
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel


class MovieDetailsScreen(private val movie: MovieUIModel) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        MovieDetailsScreenContent(movie = movie) {
            navigator.pop()
        }
    }
}