package com.shehata.movies_kmp.base.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun CircleLoading() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            Modifier.align(Alignment.Center),
            color = MaterialTheme.colors.primary
        )
    }
}