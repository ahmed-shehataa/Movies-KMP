package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel

@Composable
fun MovieSliderItem(
    movie: MovieUIModel,
    onMovieClicked: (MovieUIModel) -> Unit,
) {

    AsyncImage(
        contentScale = ContentScale.Crop,
        model = ImageRequest.Builder(LocalPlatformContext.current)
            .data(movie.backdropUrl)
            .build(),
        contentDescription = null,
        modifier = Modifier.fillMaxHeight(0.5f).clickable {
            onMovieClicked(movie)
        },
    )

}