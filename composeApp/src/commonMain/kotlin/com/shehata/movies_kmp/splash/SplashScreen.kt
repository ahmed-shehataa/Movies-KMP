package com.shehata.movies_kmp.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shehata.movies_kmp.Resources
import com.shehata.movies_kmp.login.presentation.screen.LoginScreen
import dev.icerock.moko.resources.compose.painterResource
import kotlinx.coroutines.delay

object SplashScreen : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            delay(1500)
            navigator.push(LoginScreen)
        }

        Box(Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.Center),
                painter = painterResource(Resources.images.splash),
                contentDescription = null
            )
        }

    }
}