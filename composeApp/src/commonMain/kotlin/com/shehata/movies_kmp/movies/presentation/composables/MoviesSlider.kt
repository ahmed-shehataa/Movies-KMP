package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel
import com.shehata.movies_kmp.util.compose.LocalDimen
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesSlider(
    movies: List<MovieUIModel>,
    onMovieClicked: (MovieUIModel) -> Unit,
) {
    if (movies.isEmpty())
        return

    //The problem is that the pagerState updates before the animation ends.
    // To fix this provide another key
    var isAnimating by remember { mutableStateOf(false) }

    val pagerState = rememberPagerState(pageCount = {
        movies.size
    })

    LaunchedEffect(key1 = isAnimating) {
        delay(3000)
        with(pagerState) {
            val target = if (currentPage < pageCount - 1) currentPage + 1 else 0
            animateScrollToPage(
                page = target,
                animationSpec = tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
            )
            isAnimating = !isAnimating
        }
    }

    Box {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pagerState
        ) { page ->
            val movie = movies[page]

            MovieSliderItem(
                movie = movie,
                onMovieClicked = onMovieClicked
            )
        }

        Column(
            Modifier.align(Alignment.BottomCenter)
                .background(Color.Black.copy(alpha = .5f))
                .padding(LocalDimen.current.spaceLarge),
            verticalArrangement = Arrangement.spacedBy(LocalDimen.current.spaceSmall),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (movies.isNotEmpty())
                Text(
                    text = movies[pagerState.currentPage].title ?: "",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                )

            SliderDots(count = pagerState.pageCount, currentPage = pagerState.currentPage)
        }

    }


}