package com.shehata.movies_kmp.user.data.mapper

import com.shehata.movies_kmp.user.data.model.UserDataModel
import com.shehata.movies_kmp.user.domain.model.UserDomainModel

fun UserDomainModel.toDataModel() =
    UserDataModel(
        id, name, email, token
    )
