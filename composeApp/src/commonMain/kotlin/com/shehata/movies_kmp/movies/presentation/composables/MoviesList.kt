package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel

@Composable
fun MoviesList(moviesList: List<MovieUIModel>, onMovieClicked: (MovieUIModel) -> Unit) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(moviesList) { movie ->
            MoviesItem(
                modifier = Modifier.fillMaxSize(),
                movie = movie,
                onMovieClicked = onMovieClicked
            )
        }

    }

}