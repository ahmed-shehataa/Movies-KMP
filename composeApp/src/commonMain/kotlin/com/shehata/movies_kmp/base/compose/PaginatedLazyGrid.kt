package com.shehata.movies_kmp.base.compose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shehata.movies_kmp.base.pagination.ComposePagingSource
import com.shehata.movies_kmp.base.pagination.PaginatedItem
import com.shehata.movies_kmp.base.pagination.PagingState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun <T : PaginatedItem> PaginatedLazyGrid(
    gridCells: GridCells,
    composePagingSource: ComposePagingSource<T>,
    item: @Composable (T) -> Unit,
    lazyGridState: LazyGridState = rememberLazyGridState(),
    contentPadding: PaddingValues = PaddingValues(),
    horizontalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(0.dp),
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(0.dp),
    onRefresh: () -> Unit = {},
    onRetry: () -> Unit = {
        composePagingSource.retry()
    },
    isRefreshing: Boolean = false,
    header: @Composable (() -> Unit)? = null,
    emptyPlaceHolder: @Composable () -> Unit = {
        EmptyListPlaceholder(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        )
    },
    errorPlaceHolder: @Composable () -> Unit = {
        ErrorPlaceholder(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            onRetry = onRetry
        )
    },
    loadingPlaceHolder: @Composable () -> Unit = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    },
) {

    val onRefreshingData = remember {
        {
            onRefresh()
            composePagingSource.refresh()
        }
    }

    val refreshState = rememberPullRefreshState(isRefreshing, onRefreshingData)

    val currentVisibleItem =
        remember { derivedStateOf { lazyGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index } }

    val pagingState = composePagingSource.state.collectAsState().value

    LaunchedEffect(key1 = currentVisibleItem.value) {
        // if reached to the end of current page, so load next one
        val index = currentVisibleItem.value ?: 0
        val itemIndexToLoad = lazyGridState.layoutInfo.totalItemsCount - 4

        if (itemIndexToLoad > 0)
            if (index > (lazyGridState.layoutInfo.totalItemsCount - 4)) {
                composePagingSource.loadNextPage()
            }
    }

    Box(
        Modifier
            .fillMaxSize()
            .pullRefresh(refreshState)
    ) {

        if (pagingState == PagingState.LOADING_FIRST_PAGE) {
            CircleLoading()
        } else if (pagingState == PagingState.FAILURE_AT_FIRST) {
            errorPlaceHolder()
        } else if (composePagingSource.list.isEmpty() && pagingState == PagingState.REACHED_LAST_PAGE) {
            emptyPlaceHolder()
        } else {

            LazyVerticalGrid(
                modifier = Modifier.animateContentSize(),
                columns = gridCells,
                state = lazyGridState,
                contentPadding = contentPadding,
                horizontalArrangement = horizontalArrangement,
                verticalArrangement = verticalArrangement
            ) {

                // header
                if (header != null)
                    item {
                        header()
                    }

                // list items
                items(
                    items = composePagingSource.list,
                    key = { item: PaginatedItem -> item.getId() }) {
                    item(it)
                }

                // footer (loading or error)
                item {
                    if (pagingState == PagingState.LOADING_NEXT_PAGE) {
                        loadingPlaceHolder()
                    } else if (pagingState == PagingState.FAILURE_AT_NEXT) {
                        ErrorPlaceholder(onRetry = onRetry)
                    }
                }

            }
        }

        PullRefreshIndicator(
            isRefreshing,
            refreshState,
            Modifier.align(Alignment.TopCenter)
        )
    }

}