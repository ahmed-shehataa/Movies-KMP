package com.shehata.movies_kmp.user.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserDataModel(
    val id: String,
    val name: String,
    val email: String,
    val token: String,
)