package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shehata.movies_kmp.Resources
import com.shehata.movies_kmp.movies.presentation.model.MovieUIModel
import dev.icerock.moko.resources.compose.stringResource


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoviesScreenContent(
    moviesList: List<MovieUIModel>,
    isRefreshing: Boolean,
    isRefreshState: PullRefreshState,
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


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = scaffold.calculateTopPadding(),
                    bottom = scaffold.calculateBottomPadding(),
                )
                .pullRefresh(isRefreshState)

        ) {

            MoviesList(moviesList, onMovieClicked)

            PullRefreshIndicator(
                refreshing = isRefreshing, state = isRefreshState, modifier = Modifier.align(
                    Alignment.TopCenter
                )
            )
        }
    }

}