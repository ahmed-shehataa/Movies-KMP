package com.shehata.movies_kmp.login.presentation.viewModel

import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.login.domain.LoginByEmailUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class LoginViewModel constructor(
    private val loginByEmailUseCase: LoginByEmailUseCase
) : ViewModel() {

    /**
     *
     */
    val login: MutableStateFlow<String> = MutableStateFlow("")
    val password: MutableStateFlow<String> = MutableStateFlow("")

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun onLoginClicked() {
        viewModelScope.launch {
            _isLoading.value = true
            loginByEmailUseCase.execute(
                LoginModel(
                    email = "asdas@adsa.sad",
                    password = "asdasdasd"
                )
            )
            delay(2000)
            _isLoading.value = false
        }
    }

}
