package com.shehata.movies_kmp.user.domain.usecase

import com.shehata.movies_kmp.user.data.repository.UserRepository

class SetUserLoggedInUseCase(
    private val userRepository: UserRepository
) {

    suspend fun execute() {
        userRepository.setLoggedIn()
    }
}