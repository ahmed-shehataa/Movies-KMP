package com.shehata.movies_kmp.login.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shehata.movies_kmp.base.collectActions
import com.shehata.movies_kmp.login.presentation.contract.LoginAction
import com.shehata.movies_kmp.login.presentation.contract.LoginIntent
import com.shehata.movies_kmp.login.presentation.screenModel.LoginScreenModel
import com.shehata.movies_kmp.movies.MoviesScreen
import com.shehata.movies_kmp.util.compose.LocalSnackBar


object LoginScreen : Screen {

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    override fun Content() {
        // ui states
        val screenModel = getScreenModel<LoginScreenModel>()
        val scope = rememberCoroutineScope()
        val keyboardController = LocalSoftwareKeyboardController.current
        val uiState = remember { screenModel.uiState.value }
        val emailField = remember { uiState.email }
        val passwordField = remember { uiState.password }
        val isLoading = remember { uiState.isLoading }
        val isButtonEnabled by remember(emailField.text, passwordField.text) {
            derivedStateOf {
                emailField.isValid.value && passwordField.isValid.value
            }
        }
        val onLoginClicked = remember {
            {
                keyboardController?.hide()
                screenModel.setIntent(LoginIntent.OnLoginClicked)
            }
        }

        // local providers
        val snackBar = LocalSnackBar.current
        val navigator = LocalNavigator.currentOrThrow


        // screen
        LoginScreenContent(
            isLoading = isLoading.value,
            email = emailField,
            password = passwordField,
            isButtonEnabled = isButtonEnabled,
            onLoginClicked = onLoginClicked
        )

        // Navigation observe
        screenModel.collectActions {
            when (it) {
                LoginAction.OpenHomeScreen -> {
                    navigator.replace(MoviesScreen)
                }
            }
        }
    }

}