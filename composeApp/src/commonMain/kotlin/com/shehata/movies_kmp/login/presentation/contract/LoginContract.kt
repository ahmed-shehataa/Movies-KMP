package com.shehata.movies_kmp.login.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.shehata.movies_kmp.util.validation.InputWrapper
import com.shehata.movies_kmp.util.validation.ValidationType


data class LoginUiState(
    val isLoading: MutableState<Boolean> = mutableStateOf(false),
    val isNetworkError: MutableState<Boolean> = mutableStateOf(false),
    val email: InputWrapper = InputWrapper(validationType = ValidationType.Email),
    val password: InputWrapper = InputWrapper(validationType = ValidationType.Password),
)

sealed interface LoginIntent {
    object OnLoginClicked : LoginIntent
}

sealed interface LoginAction {
    object OpenHomeScreen : LoginAction
}