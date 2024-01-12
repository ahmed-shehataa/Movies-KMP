package com.shehata.movies_kmp.login.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.shehata.movies_kmp.login.presentation.viewModel.LoginViewModel
import com.shehata.movies_kmp.util.validation.InputWrapper
import org.koin.compose.koinInject

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel = koinInject()) {
    val keyboardController = LocalSoftwareKeyboardController.current

    /*  val viewStates = remember {
          viewModel.viewStates ?: LoginViewState()
      }


      val email = remember {
          viewStates.email
      }

      val password = remember {
          viewStates.password
      }

      val isLoading = remember {
          viewStates.isLoading
      }

      val isButtonEnabled by remember(email.text, password.text) {
          derivedStateOf {
              email.isValid.value && password.isValid.value
          }
      }*/

    /*val onLoginClicked = remember {
        {
            keyboardController?.hide()
            viewModel.setEvent(
                LoginEvent.OnLoginClicked
            )
        }
    }*/


    val loading = viewModel.isLoading.collectAsState()
    LoginScreenContent(
        isLoading = loading.value,
        email = InputWrapper(),
        password = InputWrapper(),
        isButtonEnabled = true,
        onLoginClicked = {
            viewModel.onLoginClicked()
        }
    )

    /*GeneralObservers<LoginState, LoginViewModel>(viewModel = viewModel) {
        when (it) {
            LoginState.OpenRecipesScreen -> {
                navigator?.navigate(RecipesScreenDestination, navOptions = navOptions {
                    popUpTo(LoginScreenDestination.route) {
                        inclusive = true
                    }
                })
            }
        }

    }*/
}