package com.shehata.movies_kmp.login.data.remote

import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.login.data.model.LoginResponse
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class LoginRemoteDataSourceImpl :
    LoginRemoteDataSource {
    override suspend fun login(loginModel: LoginModel): LoginResponse {
        delay(1.5.seconds)
        return LoginResponse(
            id = "912235",
            name = "Ahmed Shehata",
            email = loginModel.email,
            token = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        )
    }
}