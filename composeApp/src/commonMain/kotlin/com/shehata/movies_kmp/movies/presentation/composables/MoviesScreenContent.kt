package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

import com.shehata.movies_kmp.base.pagination.ComposePagingSource
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel
import com.shehata.movies_kmp.util.compose.LocalDimen
import movies_kmp.composeapp.generated.resources.Res

import org.jetbrains.compose.resources.stringResource


@Composable
fun MoviesScreenContent(
    pagingSource: ComposePagingSource<MovieUIModel>,
    moviesSliderList: List<MovieUIModel>,
    onMovieClicked: (MovieUIModel) -> Unit,
) {


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar {
                Text(
                    text = stringResource(Res.string.movies),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = LocalDimen.current.spaceXXLarge)
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