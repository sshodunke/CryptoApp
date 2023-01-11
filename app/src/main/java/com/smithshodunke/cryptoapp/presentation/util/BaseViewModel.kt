package com.smithshodunke.cryptoapp.presentation.util

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<ViewState>(
    val initialState: ViewState
) : ViewModel() {

    private val _viewState = mutableStateOf(initialState)
    val viewState: State<ViewState>
        get() = _viewState

    protected fun setViewState(reduce: ViewState.() -> ViewState) {
        val newViewState = viewState.value.reduce()
        _viewState.value = newViewState
    }
}