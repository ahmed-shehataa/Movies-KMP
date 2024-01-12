package com.shehata.movies_kmp.user.data.local

import com.shehata.movies_kmp.user.data.model.UserDataModel


interface UserLocalDataSource {

    suspend fun setLoggedIn()

    suspend fun isLoggedIn(): Boolean

    suspend fun saveData(userDataModel: UserDataModel)

    suspend fun getData(): UserDataModel?
}