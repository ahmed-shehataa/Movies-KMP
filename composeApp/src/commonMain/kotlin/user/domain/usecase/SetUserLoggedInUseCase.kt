package user.domain.usecase

import user.data.repository.UserRepository

class SetUserLoggedInUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute() {
        userRepository.setLoggedIn()
    }
}