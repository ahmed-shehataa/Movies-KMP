package com.shehata.movies_kmp.login.presentation.screenModel

import cafe.adriel.voyager.core.model.screenModelScope
import com.shehata.movies_kmp.base.BaseScreenModel
import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.login.domain.LoginByEmailUseCase
import com.shehata.movies_kmp.login.presentation.contract.LoginAction
import com.shehata.movies_kmp.login.presentation.contract.LoginIntent
import com.shehata.movies_kmp.login.presentation.contract.LoginUiState
import kotlinx.coroutines.launch


class LoginScreenModel(
    private val loginByEmailUseCase: LoginByEmailUseCase
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
            )

            getUiState().isLoading.value = false
            // Navigate to HomeScreen
            emitAction(LoginAction.OpenHomeScreen)
        }
    }

}
