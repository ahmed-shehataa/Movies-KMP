package com.shehata.movies_kmp.user.domain.mapper

import com.shehata.movies_kmp.user.data.model.UserDataModel
import com.shehata.movies_kmp.user.domain.model.UserDomainModel

fun UserDataModel.toDomain() =
    UserDomainModel(
        id, name, email, token
    )
