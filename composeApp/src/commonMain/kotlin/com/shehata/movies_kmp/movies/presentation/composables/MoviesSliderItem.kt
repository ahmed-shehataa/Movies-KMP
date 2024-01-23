package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel

@Composable
fun MoviesSliderItem(
    movie: MovieUIModel,
    onMovieClicked: (MovieUIModel) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth().height(200.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable {
                onMovieClicked(movie)
            }
            .background(Color.LightGray),
    ) {

        AsyncImage(
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(movie.backdropUrl)
                .build(),
            contentDescription = null,
            modifier = Modifier.height(200.dp),
        )
    }

}