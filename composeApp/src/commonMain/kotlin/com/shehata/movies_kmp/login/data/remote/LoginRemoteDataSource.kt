package com.shehata.movies_kmp.login.data.remote

import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.user.data.model.UserDataModel

interface LoginRemoteDataSource {

    suspend fun login(loginModel: LoginModel) : UserDataModel
}