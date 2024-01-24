package com.shehata.movies_kmp.movie_details.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun BackButton(onBackClicked: () -> Unit, modifier: Modifier) {

    IconButton(modifier = modifier
        .clip(CircleShape)
        .background(Color.White),
        onClick = {
            onBackClicked()
        }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.Black
        )
    }

}