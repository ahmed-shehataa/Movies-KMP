package com.shehata.movies_kmp.login.domain.usecase


import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.login.data.repository.LoginRepository
import com.shehata.movies_kmp.user.domain.mapper.toDomain
import com.shehata.movies_kmp.user.domain.model.UserDomainModel

class LoginByEmailUseCase(
    private val loginRepository: LoginRepository
) {

    suspend fun execute(loginModel: LoginModel): UserDomainModel {
       return loginRepository.login(loginModel).toDomain()
    }
}