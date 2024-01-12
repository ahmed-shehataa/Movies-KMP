package com.shehata.movies_kmp.login.presentation.composables

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.shehata.movies_kmp.login.presentation.contract.LoginAction
import com.shehata.movies_kmp.login.presentation.contract.LoginIntent
import com.shehata.movies_kmp.login.presentation.viewModel.LoginViewModel
import com.shehata.movies_kmp.util.compose.collectAsEffect
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    snackBarHostState: SnackbarHostState,
    viewModel: LoginViewModel = koinInject()
) {
    /**
     * ui states
     */
    val scope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current
    val uiState = remember { viewModel.uiState.value }
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
            viewModel.setIntent(LoginIntent.OnLoginClicked)
        }
    }


    LoginScreenContent(
        isLoading = isLoading.value,
        email = emailField,
        password = passwordField,
        isButtonEnabled = isButtonEnabled,
        onLoginClicked = onLoginClicked
    )

    /**
     * Navigation
     */
    viewModel.uiAction.collectAsEffect {
        when (it) {
            LoginAction.OpenHomeScreen -> {
                scope.launch {
                    snackBarHostState.showSnackbar("OpenHomeScreen")
                }
            }
        }
    }

}