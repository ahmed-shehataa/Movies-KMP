package com.shehata.movies_kmp.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


@Composable
inline fun <UIAction> BaseScreenModel<*, *, UIAction>.collectActions(
    context: CoroutineContext = EmptyCoroutineContext,
    crossinline actionHandler: (UIAction) -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        uiAction.onEach {
            actionHandler(it)
        }.flowOn(context).launchIn(this)
    }
}