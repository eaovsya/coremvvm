package com.github.eaovsya.coremvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelsFactory<VM : ViewModel> @Inject constructor(private val viewModel: Provider<VM>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <VM : ViewModel> create(modelClass: Class<VM>): VM = viewModel.get() as VM
}