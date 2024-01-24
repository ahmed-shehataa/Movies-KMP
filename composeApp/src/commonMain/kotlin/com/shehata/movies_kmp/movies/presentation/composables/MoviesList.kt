package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shehata.movies_kmp.base.compose.PaginatedLazyGrid
import com.shehata.movies_kmp.base.pagination.ComposePagingSource
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel
import com.shehata.movies_kmp.util.compose.LocalWindowSize

@Composable
fun MoviesList(
    pagingSource: ComposePagingSource<MovieUIModel>,
    onMovieClicked: (MovieUIModel) -> Unit,
) {
    val windowSize = LocalWindowSize.current
    val minSize = remember {
        when (windowSize) {
            WindowWidthSizeClass.Compact-> { 120.dp }
            WindowWidthSizeClass.Medium-> { 150.dp }
            WindowWidthSizeClass.Expanded -> { 200.dp }
            else -> { 200.dp}
        }
    }

    PaginatedLazyGrid(
        composePagingSource = pagingSource,
        gridCells = GridCells.Adaptive(minSize = minSize),
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        item = { movie ->
            MoviesItem(
                modifier = Modifier.fillMaxSize().animateContentSize(),
                movie = movie,
                onMovieClicked = onMovieClicked
            )
        }
    )

}