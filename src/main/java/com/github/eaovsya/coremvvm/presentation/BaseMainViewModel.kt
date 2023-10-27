package com.github.eaovsya.coremvvm.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class BaseMainViewModel @Inject constructor(
    private val globalErrorCommunication: GlobalErrorCommunication.Mutable
) : GlobalErrorCommunication.Observe, ViewModel() {

    override fun observe(owner: LifecycleOwner, observer: Observer<String>) {
        globalErrorCommunication.observe(owner, observer)
    }
}