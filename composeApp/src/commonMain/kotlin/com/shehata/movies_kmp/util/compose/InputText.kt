package com.shehata.movies_kmp.util.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.shehata.movies_kmp.util.validation.InputWrapper
import com.shehata.movies_kmp.util.validation.ValidationType
import movies_kmp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun InputText(
    hint: StringResource,
    inputWrapper: InputWrapper,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onDone: () -> Unit,
) {

    val focusManager = LocalFocusManager.current

    val text by remember {
        inputWrapper.text
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    val trailingIcon: @Composable (() -> Unit)? = remember(inputWrapper.validationType) {
        {
            if (inputWrapper.validationType == ValidationType.Password) {
                val iconRes = if (isPasswordVisible)
                    Res.drawable.ic_eye_opened
                else Res.drawable.ic_eye_closed

                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(iconRes),
                        contentDescription = null,
                    )
                }
            } else null
        }
    }


    val visualTransformation by remember {
        derivedStateOf {
            if (inputWrapper.validationType == ValidationType.Password && !isPasswordVisible)
                PasswordVisualTransformation()
            else VisualTransformation.None
        }
    }

    Column {

        Row(
            modifier = Modifier
                .requiredHeight(50.dp)
                .clip(MaterialTheme.shapes.medium)
                .border(
                    1.dp, Color.Gray, MaterialTheme.shapes.medium
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

            TextField(
                placeholder = {
                    Text(
                        stringResource(hint),
                        style = MaterialTheme.typography.button
                    )
                },
                value = text,
                onValueChange = {
                    inputWrapper.onValueChange(it)
                },
                textStyle = MaterialTheme.typography.body2,
                modifier = Modifier.weight(1F),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    },
                    onDone = {
                        onDone()
                        focusManager.clearFocus()
                    }

                ),
                visualTransformation = visualTransformation,
                trailingIcon = trailingIcon
            )
        }

        AnimatedVisibility(
            visible = inputWrapper.isValid.value.not() && inputWrapper.text.value.isNotEmpty(),
            enter = scaleIn() + expandVertically(expandFrom = Alignment.CenterVertically),
            exit = scaleOut() + shrinkVertically(shrinkTowards = Alignment.CenterVertically)
        ) {
            Text(
                text = stringResource(inputWrapper.validationMessageResId),
                color = Color.Red,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

    }

}