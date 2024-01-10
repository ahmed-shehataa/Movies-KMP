package user.data.repository

import user.data.local.UserLocalDataSource
import user.data.local.UserLocalDataSourceImpl
import user.data.model.UserDataModel

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