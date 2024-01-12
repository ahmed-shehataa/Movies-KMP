package com.shehata.movies_kmp.login.domain


import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.login.data.repository.LoginRepository

class LoginByEmailUseCase(
    private val loginRepository: LoginRepository
) {

    suspend fun execute(loginModel: LoginModel) {
        loginRepository.login(loginModel)
    }
}