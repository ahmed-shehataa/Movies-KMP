package com.shehata.movies_kmp.movies.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shehata.movies_kmp.util.compose.LocalDimen

@Composable
fun SliderDots(count: Int, currentPage: Int) {
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = LocalDimen.current.spaceSmall),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(count) { iteration ->
            val color = if (currentPage == iteration)
                Color.LightGray else Color.DarkGray
            Box(
                modifier = Modifier
                    .padding(LocalDimen.current.spaceXXXSmall)
                    .clip(CircleShape)
                    .background(color)
                    .size(12.dp)
            )
        }
    }
}
