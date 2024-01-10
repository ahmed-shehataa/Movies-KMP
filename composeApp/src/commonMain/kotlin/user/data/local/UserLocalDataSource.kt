package user.data.local

import user.data.model.UserDataModel

interface UserLocalDataSource {

    suspend fun setLoggedIn()

    suspend fun isLoggedIn(): Boolean

    suspend fun saveData(userDataModel: UserDataModel)

    suspend fun getData(): UserDataModel?
}