package com.shehata.movies_kmp.user.domain.usecase

import com.shehata.movies_kmp.user.data.mapper.toDataModel
import com.shehata.movies_kmp.user.data.repository.UserRepository
import com.shehata.movies_kmp.user.domain.model.UserDomainModel

class SaveUserDataUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute(userDomainModel: UserDomainModel) {
        userRepository.saveData(userDomainModel.toDataModel())
    }
}