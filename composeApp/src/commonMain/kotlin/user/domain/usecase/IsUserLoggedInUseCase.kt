package user.domain.usecase

import user.data.repository.UserRepository

class IsUserLoggedInUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute(): Boolean {
        return userRepository.isLoggedIn()
    }
}