package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.LocalPlatformContext
import coil3.request.ImageRequest
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel

@Composable
fun MoviesItem(
    modifier: Modifier,
    movie: MovieUIModel,
    onMovieClicked: (MovieUIModel) -> Unit,
) {
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onMovieClicked(movie)
            }
            .background(Color.LightGray),
    ) {

        AsyncImage(
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(LocalPlatformContext.current)
                .data(movie.posterUrl)
                .build(),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.Black.copy(alpha = .5f))
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Text(
                text = movie.title ?: "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(
                    color = Color.White,
                )
            )
            Text(
                text = movie.releaseDate ?: "",
                fontSize = 18.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        VoteBadge(
            Modifier
                .align(Alignment.TopEnd)
                .padding(top = 12.dp, end = 12.dp), movie
        )

    }

}