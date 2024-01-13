package com.shehata.movies_kmp.util.logging

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

@Composable
internal fun initNapier() {
    LaunchedEffect(Unit) {
        Napier.base(DebugAntilog())
    }
}