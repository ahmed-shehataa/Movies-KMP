package com.shehata.movies_kmp.splash.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shehata.movies_kmp.Resources
import com.shehata.movies_kmp.base.collectActions
import com.shehata.movies_kmp.login.presentation.screen.LoginScreen
import com.shehata.movies_kmp.movies.MoviesScreen
import com.shehata.movies_kmp.splash.presentation.contract.SplashAction
import com.shehata.movies_kmp.splash.presentation.screenModel.SplashScreenModel
import dev.icerock.moko.resources.compose.painterResource

object SplashScreen : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<SplashScreenModel>()

        Box(Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.Center),
                painter = painterResource(Resources.images.splash),
                contentDescription = null
            )
        }

        screenModel.collectActions {
            when (it) {
                SplashAction.OpenMoviesScreen -> navigator.replace(MoviesScreen)
                SplashAction.OpenLoginScreen -> navigator.replace(LoginScreen)
            }
        }

    }
}