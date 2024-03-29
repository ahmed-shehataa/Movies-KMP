package com.shehata.movies_kmp.base.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


import movies_kmp.composeapp.generated.resources.Res

import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun ErrorPlaceholder(modifier: Modifier = Modifier, onRetry: () -> Unit) {

    Box(modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(Res.drawable.ic_error),
                contentDescription = null,
            )

            Text(
                text = stringResource(Res.string.network_error),
                style = MaterialTheme.typography.body1.copy(
                    color = MaterialTheme.colors.primary
                )
            )

            Button(onClick = onRetry, content = {
                Text(
                    text = stringResource(Res.string.retry),
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.White
                    )
                )
            })

        }
    }
}