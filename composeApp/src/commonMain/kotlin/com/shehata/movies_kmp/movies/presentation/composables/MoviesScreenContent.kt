package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shehata.movies_kmp.Resources
import com.shehata.movies_kmp.base.pagination.ComposePagingSource
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel
import dev.icerock.moko.resources.compose.stringResource


@Composable
fun MoviesScreenContent(
    pagingSource: ComposePagingSource<MovieUIModel>,
    moviesSliderList: List<MovieUIModel>,
    onMovieClicked: (MovieUIModel) -> Unit,
    onTryAgain: () -> Unit,
) {


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar {
                Text(
                    text = stringResource(Resources.strings.movies),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    ) { scaffold ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    //top = scaffold.calculateTopPadding(),
                    bottom = scaffold.calculateBottomPadding(),
                )

        ) {
            MoviesSlider(moviesSliderList, onMovieClicked)
            MoviesList(pagingSource, onMovieClicked)
        }
    }

}