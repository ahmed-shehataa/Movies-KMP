package com.shehata.movies_kmp.user.domain.usecase

import com.shehata.movies_kmp.user.data.model.UserDataModel
import com.shehata.movies_kmp.user.data.repository.UserRepository


class GetUserDataUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute(): UserDataModel? {
        return userRepository.getData()
    }
}