package com.shehata.movies_kmp.login.data.remote

import com.shehata.movies_kmp.login.data.model.LoginModel
import com.shehata.movies_kmp.user.data.model.UserDataModel
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class LoginRemoteDataSourceImpl : LoginRemoteDataSource {
    override suspend fun login(loginModel: LoginModel): UserDataModel {
        delay(1.5.seconds)
        return UserDataModel(
            id = "912235",
            name = "Ahmed Shehata",
            email = loginModel.email,
            token = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        )
    }
}