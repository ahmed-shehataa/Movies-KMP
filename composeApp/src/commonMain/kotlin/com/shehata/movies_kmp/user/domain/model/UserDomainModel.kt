package com.shehata.movies_kmp.user.domain.model

data class UserDomainModel(
    val id: String,
    val name: String,
    val email: String,
    val token: String,
)