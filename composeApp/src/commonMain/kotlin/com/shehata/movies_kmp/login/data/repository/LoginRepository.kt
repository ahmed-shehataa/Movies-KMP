package com.shehata.movies_kmp.login.data.repository

import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.login.data.remote.LoginRemoteDataSource
import com.shehata.movies_kmp.user.data.model.UserDataModel

class LoginRepository(
    private val loginRemoteDataSource: LoginRemoteDataSource
) {

    suspend fun login(loginModel: LoginModel): UserDataModel {
        return loginRemoteDataSource.login(loginModel)
    }
}