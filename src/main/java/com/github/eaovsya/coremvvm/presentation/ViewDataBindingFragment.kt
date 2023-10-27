package com.github.eaovsya.coremvvm.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Abstract class that inflates provided view with [ViewDataBinding]
 */
abstract class ViewDataBindingFragment<DB : ViewDataBinding>(
    private val layoutResId: Int
) : Fragment() {

    protected val binding: DB
        get() = _binding!!
    private var _binding: DB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater,
            layoutResId,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}