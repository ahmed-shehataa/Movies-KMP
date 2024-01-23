package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel
import com.shehata.movies_kmp.movies.presentation.model.VoteRate
import kotlin.math.round

@Composable
fun VoteBadge(
    modifier: Modifier,
    movie: MovieUIModel
) {

    val color = remember {
        when (movie.voteRate) {
            VoteRate.HIGH -> Color.Red
            VoteRate.MEDIUM -> Color.Blue
            VoteRate.LOW -> Color.Green
            VoteRate.UNKNOWN -> Color.Gray
        }
    }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color)
            .padding(8.dp), contentAlignment = Alignment.Center
    ) {

        Text(
            text = (round(movie.voteAverage ?: 0.0)).toString(),
            fontSize = 18.sp,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

}