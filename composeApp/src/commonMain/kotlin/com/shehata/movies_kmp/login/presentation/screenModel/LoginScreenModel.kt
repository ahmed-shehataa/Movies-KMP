package com.shehata.movies_kmp.login.presentation.screenModel

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.login.domain.LoginByEmailUseCase
import com.shehata.movies_kmp.login.presentation.contract.LoginAction
import com.shehata.movies_kmp.login.presentation.contract.LoginIntent
import com.shehata.movies_kmp.login.presentation.contract.LoginUiState
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class LoginScreenModel(
    private val loginByEmailUseCase: LoginByEmailUseCase
) : ScreenModel {

    /**
     * TODO MOVE them to BaseViewModel
     */
    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    private val _uiIntent: MutableSharedFlow<LoginIntent> = MutableSharedFlow()

    private val _uiAction: MutableSharedFlow<LoginAction> = MutableSharedFlow()
    val uiAction: MutableSharedFlow<LoginAction> = _uiAction

    private fun resetUiStates() {

    }

    /**
     * TODO to handle desktop dispatcher error
     */
    private fun handleIntents() {
        screenModelScope.launch(/*Dispatchers.IO*/) {
            _uiIntent.collectLatest {
                Napier.i(tag = "_uiIntent:", message = "handleIntents")
                when (it) {
                    is LoginIntent.OnLoginClicked -> onLoginClicked()
                }
            }
        }
    }

    fun setIntent(uiIntent: LoginIntent) {
        screenModelScope.launch { _uiIntent.emit(uiIntent) }
    }

    init {
        handleIntents()
    }

    /**
     *
     */

    private fun onLoginClicked() {
        screenModelScope.launch {
            _uiState.value.isLoading.value = true
            val email = _uiState.value.email.text.value
            val password = _uiState.value.password.text.value

            loginByEmailUseCase.execute(
                LoginModel(
                    email = email,
                    password = password
                )
            )

            _uiState.value.isLoading.value = false
            // Navigate to HomeScreen
            _uiAction.emit(LoginAction.OpenHomeScreen)
        }
    }

}
