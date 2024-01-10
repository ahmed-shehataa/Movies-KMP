package user.domain.usecase

import user.data.model.UserDataModel
import user.data.repository.UserRepository

class SaveUserDataUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute(userDataModel: UserDataModel) {
        userRepository.saveData(userDataModel)
    }
}