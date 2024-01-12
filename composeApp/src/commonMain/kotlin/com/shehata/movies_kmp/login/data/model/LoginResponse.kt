package com.shehata.movies_kmp.login.data.model

data class LoginResponse(
    val id: String,
    val name: String,
    val email: String,
    val token: String,
)
