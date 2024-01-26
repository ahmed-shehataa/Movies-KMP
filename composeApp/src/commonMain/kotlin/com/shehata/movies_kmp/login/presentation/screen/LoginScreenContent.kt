package com.shehata.movies_kmp.login.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.shehata.movies_kmp.Resources
import com.shehata.movies_kmp.util.compose.InputText
import com.shehata.movies_kmp.util.compose.LocalDimen
import com.shehata.movies_kmp.util.compose.LocalWindowSize
import com.shehata.movies_kmp.util.validation.InputWrapper
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun LoginScreenContent(
    email: InputWrapper,
    password: InputWrapper,
    isButtonEnabled: Boolean,
    onLoginClicked: () -> Unit,
    isLoading: Boolean,
) {

    val focusManager = LocalFocusManager.current

    val windowSize = LocalWindowSize.current

    val widthFraction = remember {
        when (windowSize) {
            WindowWidthSizeClass.Compact -> {
                1f
            }

            else -> {
                0.5f
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier.fillMaxWidth(widthFraction)
                .background(Color.White)
                .padding(horizontal = LocalDimen.current.spaceXXXLarge)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(LocalDimen.current.spaceLarge),
        ) {


            Spacer(modifier = Modifier.height(LocalDimen.current.spaceXXXLarge))

            Image(
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(Resources.images.login),
                contentDescription = null
            )

            InputText(
                hint = Resources.strings.enter_email,
                inputWrapper = email,
                keyboardType = KeyboardType.Email
            ) {

            }


            InputText(
                inputWrapper = password,
                hint = Resources.strings.enter_password,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                onDone = {
                    if (isButtonEnabled)
                        onLoginClicked()
                }
            )

            Button(
                modifier = Modifier
                    .requiredHeight(50.dp)
                    .fillMaxWidth(),
                onClick = {
                    focusManager.clearFocus()
                    onLoginClicked()
                },
                content = {
                    Text(text = stringResource(Resources.strings.login))
                },
                enabled = isButtonEnabled,
                shape = MaterialTheme.shapes.medium
            )

            Spacer(Modifier.padding(bottom = LocalDimen.current.spaceXXXLarge))

        }

        if (isLoading) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black.copy(alpha = 0.5f)
            ) {

                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
        }
    }
}