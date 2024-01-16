package com.shehata.movies_kmp.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.shehata.movies_kmp.util.compose.LocalSnackBar
import kotlin.jvm.Transient

open class BaseScreen<UIState, UIIntent, UIAction>(
    @Transient
    private val model: @Composable Screen.() -> BaseScreenModel<UIState, UIIntent, UIAction>,
    @Transient
    private val content: @Composable (
        screenModel: BaseScreenModel<UIState, UIIntent, UIAction>,
        uiState: UIState,
        snackBar: SnackbarHostState
    ) -> Unit = { _, _, _ ->
        Box(Modifier.fillMaxSize()) {
            Text(modifier = Modifier.align(Alignment.Center), text = "BaseScreen")
        }
    },
    @Transient
    private val onAction: (action: UIAction, navigator: Navigator) -> Unit = { _, _ ->
    }
) : Screen {

    @Composable
    override fun Content() {
        // states
        val sm = model(this)
        val uiState = sm.uiState.collectAsState().value
        val snackBar = LocalSnackBar.current
        val navigator = LocalNavigator.currentOrThrow

        // content
        content(sm, uiState, snackBar)

        // Action
        sm.collectActions {
            onAction(it, navigator)
        }
    }

}