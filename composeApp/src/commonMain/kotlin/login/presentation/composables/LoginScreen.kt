package login.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import login.presentation.viewModel.LoginViewModel
import util.validation.InputWrapper

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel = LoginViewModel()) {

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


    LoginScreenContent(
        isLoading = false,
        email = InputWrapper(),
        password = InputWrapper(),
        isButtonEnabled = true,
        onLoginClicked = {

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