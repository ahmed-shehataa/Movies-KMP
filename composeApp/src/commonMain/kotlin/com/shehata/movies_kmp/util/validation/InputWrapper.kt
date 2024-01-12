package com.shehata.movies_kmp.util.validation


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import com.shehata.movies_kmp.Resources
import com.shehata.movies_kmp.util.validation.Validation.validateEmail
import com.shehata.movies_kmp.util.validation.Validation.validateText
import dev.icerock.moko.resources.StringResource

enum class ValidationType {
    Text, Email, Password
}

data class InputWrapper(
    var text: MutableState<String> = mutableStateOf(""),
    var isValid: MutableState<Boolean> = mutableStateOf(false),
    var borderColor: Color = Color.Gray,
    val validationType: ValidationType? = ValidationType.Text
) {

    var validationMessageResId: StringResource = Resources.strings.empty_lbl

    fun onValueChange(input: String) {
        text.value = input
        validationMessageResId = when (validationType) {
            ValidationType.Email -> input.validateEmail().toMessageRes()
            else -> input.validateText().toMessageRes()
        }
        borderColor = if (isValid.value) {
            Color.Gray
        } else {
            Color.Red
        }
        isValid.value =
            validationMessageResId == Resources.strings.empty_lbl && text.value.isNotEmpty()
    }
}

private fun ValidationMessageType.toMessageRes(): StringResource {
    return when (this) {
        ValidationMessageType.EmptyField -> Resources.strings.empty_field
        is ValidationMessageType.Invalid -> {
            when (this.validationType) {
                ValidationType.Email -> Resources.strings.invalid_email
                else -> Resources.strings.invalid_email
            }
        }

        ValidationMessageType.Valid -> Resources.strings.empty_lbl
    }
}