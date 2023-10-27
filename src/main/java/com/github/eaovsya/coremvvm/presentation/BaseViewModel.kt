package com.github.eaovsya.coremvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.eaovsya.coremvvm.core.Dispatchers

abstract class BaseViewModel(
    private val dispatchers: Dispatchers
) : ViewModel() {

    protected fun <T> handle(
        block: suspend () -> T
    ) = dispatchers.launchBackground(viewModelScope) {
        block.invoke()
    }
}