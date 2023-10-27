package com.github.eaovsya.coremvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**@SelfDocumented*/
class ViewModelsFactory<VM : ViewModel> @Inject constructor(private val viewModel: Provider<VM>) :
    ViewModelProvider.Factory {

    /**@SelfDocumented*/
    @Suppress("UNCHECKED_CAST")
    override fun <VM : ViewModel> create(modelClass: Class<VM>): VM = viewModel.get() as VM
}