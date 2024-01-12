package com.shehata.movies_kmp.user.data.repository

import com.shehata.movies_kmp.user.data.local.UserLocalDataSource
import com.shehata.movies_kmp.user.data.local.UserLocalDataSourceImpl
import com.shehata.movies_kmp.user.data.model.UserDataModel

class UserRepository(
    private val userLocalDataSource: UserLocalDataSource = UserLocalDataSourceImpl()
) {

    suspend fun setLoggedIn() {
        userLocalDataSource.setLoggedIn()
    }

    suspend fun isLoggedIn(): Boolean {
        return userLocalDataSource.isLoggedIn()
    }

    suspend fun saveData(userDataModel: UserDataModel) {
        userLocalDataSource.saveData(userDataModel)
    }

    suspend fun getData(): UserDataModel? {
        return userLocalDataSource.getData()
    }
}