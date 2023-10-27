package com.github.eaovsya.coremvvm.presentation

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseFragment<DB : ViewDataBinding, VM : ViewModel>(layoutResId: Int) : ViewModelInjectionFragment<DB, VM>(layoutResId)