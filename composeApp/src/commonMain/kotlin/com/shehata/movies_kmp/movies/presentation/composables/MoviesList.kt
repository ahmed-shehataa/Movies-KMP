package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesList(moviesList: List<MovieUIModel>, onMovieClicked: (MovieUIModel) -> Unit) {

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = 0, initialPageOffsetFraction = 0f
    ) { moviesList.size }


    Box(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HorizontalPager(
            modifier = Modifier.align(Alignment.Center),
            state = pagerState, contentPadding = PaddingValues(all = 16.dp), pageSpacing = 12.dp
        ) {
            MoviesItem(
                modifier = Modifier.fillMaxSize(),
                movie = moviesList[it],
                isSelected = it == pagerState.currentPage,
                onMovieClicked = onMovieClicked
            )
        }

    }

}