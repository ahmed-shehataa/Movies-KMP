package com.shehata.movies_kmp.user.data.local

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.SuspendSettings
import com.russhwolf.settings.coroutines.toBlockingSettings
import com.russhwolf.settings.coroutines.toSuspendSettings
import com.russhwolf.settings.serialization.decodeValueOrNull
import com.russhwolf.settings.serialization.encodeValue
import com.shehata.movies_kmp.user.data.model.UserDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.serialization.ExperimentalSerializationApi


@OptIn(ExperimentalSettingsApi::class, ExperimentalSerializationApi::class)
class UserLocalDataSourceImpl(
    private val settings: SuspendSettings = Settings().toSuspendSettings(Dispatchers.IO)
) : UserLocalDataSource {

    companion object {
        const val LOGGED_IN_KEY = "is_logged_in"
        const val USER_KEY = "user"
    }

    override suspend fun setLoggedIn() {
        settings.putBoolean(LOGGED_IN_KEY, true)
    }

    override suspend fun isLoggedIn(): Boolean {
        return settings.getBoolean(LOGGED_IN_KEY, false)
    }

    override suspend fun saveData(userDataModel: UserDataModel) {
        settings
            .toBlockingSettings()
            .encodeValue(UserDataModel.serializer(), USER_KEY, userDataModel)
    }

    override suspend fun getData(): UserDataModel? {
        return settings
            .toBlockingSettings()
            .decodeValueOrNull(UserDataModel.serializer(), USER_KEY)
    }
}