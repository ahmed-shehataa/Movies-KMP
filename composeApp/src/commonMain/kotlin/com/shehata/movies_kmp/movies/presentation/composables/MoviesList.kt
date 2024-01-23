package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shehata.movies_kmp.base.compose.PaginatedLazyGrid
import com.shehata.movies_kmp.base.pagination.ComposePagingSource
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel

@Composable
fun MoviesList(
    pagingSource: ComposePagingSource<MovieUIModel>,
    onMovieClicked: (MovieUIModel) -> Unit,
) {

    PaginatedLazyGrid(
        composePagingSource = pagingSource,
        gridCells = GridCells.Adaptive(minSize = 120.dp),
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        item = { movie ->
            MoviesItem(
                modifier = Modifier.fillMaxSize(),
                movie = movie,
                onMovieClicked = onMovieClicked
            )
        }
    )

}