package com.shehata.movies_kmp.user.domain.usecase

import com.shehata.movies_kmp.user.data.repository.UserRepository

class IsUserLoggedInUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute(): Boolean {
        return userRepository.isLoggedIn()
    }
}