package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shehata.movies_kmp.base.compose.PaginatedLazyGrid
import com.shehata.movies_kmp.base.pagination.ComposePagingSource
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel
import com.shehata.movies_kmp.util.compose.LocalDimen

@Composable
fun MoviesList(
    pagingSource: ComposePagingSource<MovieUIModel>,
    onMovieClicked: (MovieUIModel) -> Unit,
) {
    PaginatedLazyGrid(
        composePagingSource = pagingSource,
        gridCells = GridCells.Adaptive(minSize = LocalDimen.current.movieCardSize),
        contentPadding = PaddingValues(LocalDimen.current.spaceLarge),
        horizontalArrangement = Arrangement.spacedBy(LocalDimen.current.spaceLarge),
        verticalArrangement = Arrangement.spacedBy(LocalDimen.current.spaceLarge),
        item = { movie ->
            MoviesItem(
                modifier = Modifier.fillMaxSize().animateContentSize(),
                movie = movie,
                onMovieClicked = onMovieClicked
            )
        }
    )

}