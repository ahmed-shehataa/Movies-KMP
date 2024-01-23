package com.shehata.movies_kmp.login.presentation.screenModel

import cafe.adriel.voyager.core.model.screenModelScope
import com.shehata.movies_kmp.base.screenModel.BaseScreenModel
import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.login.domain.usecase.LoginByEmailUseCase
import com.shehata.movies_kmp.login.presentation.contract.LoginAction
import com.shehata.movies_kmp.login.presentation.contract.LoginIntent
import com.shehata.movies_kmp.login.presentation.contract.LoginUiState
import com.shehata.movies_kmp.user.domain.usecase.SaveUserDataUseCase
import com.shehata.movies_kmp.user.domain.usecase.SetUserLoggedInUseCase
import kotlinx.coroutines.launch


class LoginScreenModel(
    private val loginByEmailUseCase: LoginByEmailUseCase,
    private val setUserLoggedInUseCase: SetUserLoggedInUseCase,
    private val saveUserDataUseCase: SaveUserDataUseCase
) : BaseScreenModel<LoginUiState, LoginIntent, LoginAction>() {


    override fun createInitialState(): LoginUiState = LoginUiState()

    override suspend fun handleIntent(uiIntent: LoginIntent) {
        when (uiIntent) {
            is LoginIntent.OnLoginClicked -> onLoginClicked()
        }
    }

    private fun onLoginClicked() {
        screenModelScope.launch {
            getUiState().isLoading.value = true
            val email = getUiState().email.text.value
            val password = getUiState().password.text.value

            loginByEmailUseCase.execute(
                LoginModel(
                    email = email,
                    password = password
                )
            ).apply {
                setUserLoggedInUseCase.execute()
                saveUserDataUseCase.execute(this)
            }

            getUiState().isLoading.value = false
            // Navigate to HomeScreen
            emitAction(LoginAction.OpenHomeScreen)
        }
    }

}
