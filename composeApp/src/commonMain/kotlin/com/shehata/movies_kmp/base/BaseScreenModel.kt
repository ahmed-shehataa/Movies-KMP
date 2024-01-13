package com.shehata.movies_kmp.base

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseScreenModel<UIState, UIIntent, UIAction> : ScreenModel {

    private val _uiState: MutableStateFlow<UIState> = MutableStateFlow(createInitialState())
    val uiState: StateFlow<UIState> = _uiState

    private val _uiIntent: MutableSharedFlow<UIIntent> = MutableSharedFlow()
    val uiIntent: MutableSharedFlow<UIIntent> = _uiIntent

    private val _uiAction: MutableSharedFlow<UIAction> = MutableSharedFlow()
    val uiAction: MutableSharedFlow<UIAction> = _uiAction


    init {
        handleIntents()
    }

    abstract fun createInitialState(): UIState

    private fun handleIntents() {
        screenModelScope.launch {
            _uiIntent.collectLatest { uiIntent ->
                handleIntent(uiIntent)
            }
        }
    }

    abstract suspend fun handleIntent(uiIntent: UIIntent)


    fun setIntent(uiIntent: UIIntent) {
        screenModelScope.launch {
            _uiIntent.emit(uiIntent)
        }
    }

    protected fun getUiState() : UIState{
        return _uiState.value
    }

    protected fun emitAction(uiAction: UIAction) {
        screenModelScope.launch {
            _uiAction.emit(uiAction)
        }
    }

    override fun onDispose() {
        super.onDispose()

    }


}