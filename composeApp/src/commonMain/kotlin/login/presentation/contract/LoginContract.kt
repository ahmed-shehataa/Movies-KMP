package login.presentation.contract

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import util.validation.InputWrapper
import util.validation.ValidationType


data class LoginViewState(
    val isRefreshing: MutableState<Boolean> = mutableStateOf(false),
    val isNetworkError: MutableState<Boolean> = mutableStateOf(false),
    val email: InputWrapper = InputWrapper(validationType = ValidationType.Email),
    val password: InputWrapper = InputWrapper(validationType = ValidationType.Password),
)