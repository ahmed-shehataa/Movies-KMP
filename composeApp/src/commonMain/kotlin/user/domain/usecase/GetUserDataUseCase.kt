package user.domain.usecase

import user.data.model.UserDataModel
import user.data.repository.UserRepository

class GetUserDataUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute(): UserDataModel? {
        return userRepository.getData()
    }
}