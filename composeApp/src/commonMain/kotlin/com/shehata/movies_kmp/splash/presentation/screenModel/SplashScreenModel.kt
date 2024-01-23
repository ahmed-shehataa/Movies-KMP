package com.shehata.movies_kmp.splash.presentation.screenModel

import cafe.adriel.voyager.core.model.screenModelScope
import com.shehata.movies_kmp.base.screenModel.BaseScreenModel
import com.shehata.movies_kmp.splash.presentation.contract.SplashAction
import com.shehata.movies_kmp.user.domain.usecase.IsUserLoggedInUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenModel(
    private val isUserLoggedInUseCase: IsUserLoggedInUseCase,
) : BaseScreenModel<Any, Any, SplashAction>() {

    init {
        navigateTo()
    }

    private fun navigateTo() {
        screenModelScope.launch {
            delay(1000)
            if (isUserLoggedInUseCase.execute()) {
                emitAction(SplashAction.OpenMoviesScreen)
            } else
                emitAction(SplashAction.OpenLoginScreen)
        }
    }

    override fun createInitialState(): Any = Any()

    override suspend fun handleIntent(uiIntent: Any) {}


}
