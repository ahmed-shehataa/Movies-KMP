package com.shehata.movies_kmp.login.presentation.screen

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import cafe.adriel.voyager.koin.getScreenModel
import com.shehata.movies_kmp.base.BaseScreen
import com.shehata.movies_kmp.login.presentation.contract.LoginAction
import com.shehata.movies_kmp.login.presentation.contract.LoginIntent
import com.shehata.movies_kmp.login.presentation.contract.LoginUiState
import com.shehata.movies_kmp.login.presentation.screenModel.LoginScreenModel
import com.shehata.movies_kmp.movies.MoviesScreen


@OptIn(ExperimentalComposeUiApi::class)
object LoginScreen : BaseScreen<LoginUiState, LoginIntent, LoginAction>(
    model = { getScreenModel<LoginScreenModel>() },
    content = { screenModel, uiState, snackBar ->

        val keyboardController = LocalSoftwareKeyboardController.current
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

        LoginScreenContent(
            isLoading = isLoading.value,
            email = emailField,
            password = passwordField,
            isButtonEnabled = isButtonEnabled,
            onLoginClicked = onLoginClicked
        )
    },

    onAction = { action, navigator ->
        when (action) {
            LoginAction.OpenHomeScreen -> {
                navigator.replace(MoviesScreen)
            }
        }
    }
)