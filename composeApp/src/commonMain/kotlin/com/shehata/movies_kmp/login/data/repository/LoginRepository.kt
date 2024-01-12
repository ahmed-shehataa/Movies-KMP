package com.shehata.movies_kmp.login.data.repository

import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.login.data.model.LoginResponse
import com.shehata.movies_kmp.login.data.remote.LoginRemoteDataSource

class LoginRepository(
    private val loginRemoteDataSource: LoginRemoteDataSource
) {

    suspend fun login(loginModel: LoginModel): LoginResponse {
        return loginRemoteDataSource.login(loginModel)
    }
}