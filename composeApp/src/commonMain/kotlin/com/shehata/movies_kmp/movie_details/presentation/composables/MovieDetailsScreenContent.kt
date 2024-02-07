package com.shehata.movies_kmp.movie_details.presentation.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.shehata.movies_kmp.movies.presentation.composables.VoteBadge
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel
import com.shehata.movies_kmp.util.compose.LocalDimen
import movies_kmp.composeapp.generated.resources.Res


@Composable
fun MovieDetailsScreenContent(
    movie: MovieUIModel,
    onBackClicked: () -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        LazyColumn {
            item {
                AsyncImage(
                    modifier = Modifier
                        .defaultMinSize(minHeight = LocalDimen.current.spaceXXXLarge)
                        .fillParentMaxWidth()
                        .wrapContentHeight()
                        .animateContentSize(),
                    contentScale = ContentScale.Crop,
                    model = movie.backdropUrl,
                    contentDescription = null,
                )
            }

            item { Spacer(modifier = Modifier.height(LocalDimen.current.spaceLarge)) }

            item {
                movie.title?.let {
                    TitleWithDescriptionItem(
                        titleRes = Res.string.name,
                        description = movie.title
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(LocalDimen.current.spaceLarge)) }

            item {
                movie.overview?.let {
                    TitleWithDescriptionItem(
                        titleRes = Res.string.overview,
                        description = movie.overview
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(LocalDimen.current.spaceLarge)) }

            item {
                movie.releaseDate?.let {
                    TitleWithDescriptionItem(
                        titleRes = Res.string.release_date,
                        description = movie.releaseDate
                    )
                }
            }
        }

        BackButton(
            onBackClicked,
            Modifier
                .align(Alignment.TopStart)
                .statusBarsPadding()
                .padding(start = LocalDimen.current.spaceLarge, top = LocalDimen.current.spaceLarge)

        )

        VoteBadge(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .statusBarsPadding()
                .padding(end = LocalDimen.current.spaceLarge, top = LocalDimen.current.spaceLarge),
            movie = movie

        )
    }

}