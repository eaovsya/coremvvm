package com.github.eaovsya.coremvvm.presentation

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.eaovsya.coremvvm.di.FragmentInjector
import com.github.eaovsya.coremvvm.di.ViewModelsFactory
import javax.inject.Inject

/**
 * Abstract class that provides auto injection of ViewModels and DaggerComponent
 */
abstract class ViewModelInjectionFragment<DB : ViewDataBinding, VM : ViewModel>(
    layoutResId: Int
) : ViewDataBindingFragment<DB>(layoutResId) {

    protected abstract fun viewModelClass(): Class<VM>

    protected abstract val injector: FragmentInjector

    @Inject
    internal lateinit var viewModelsFactory: ViewModelsFactory<VM>
    protected val viewModel: VM by lazy {
        ViewModelProvider(this, viewModelsFactory)[viewModelClass()]
    }

    override fun onAttach(context: Context) {
        injector.inject()
        super.onAttach(context)
    }
}