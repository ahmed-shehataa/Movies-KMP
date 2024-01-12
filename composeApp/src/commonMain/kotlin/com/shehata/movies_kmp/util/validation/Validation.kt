package com.shehata.movies_kmp.util.validation

import com.shehata.movies_kmp.util.validation.patterns.EMAIL_ADDRESS_PATTERN


sealed class ValidationMessageType(val validationType: ValidationType? = null) {
    object EmptyField : ValidationMessageType()
    data class Invalid(val type: ValidationType?) : ValidationMessageType(type)
    object Valid : ValidationMessageType()
}

object Validation {
    fun String.validateEmail(): ValidationMessageType {
        return if (this.isEmpty()) ValidationMessageType.EmptyField
        else if (EMAIL_ADDRESS_PATTERN.matches(this.trim()).not())
            ValidationMessageType.Invalid(ValidationType.Email)
        else ValidationMessageType.Valid
    }

    fun String.validateText(): ValidationMessageType {
        return if (this.isEmpty()) ValidationMessageType.EmptyField
        else ValidationMessageType.Valid
    }
}