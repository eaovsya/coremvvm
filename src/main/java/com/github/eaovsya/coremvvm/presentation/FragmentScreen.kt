package com.github.eaovsya.coremvvm.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.github.eaovsya.coremvvm.core.FragmentProvider

abstract class FragmentScreen(
    private val fragmentProvider: FragmentProvider,
    private val strategy: ShowStrategy
) {

    override fun toString(): String = fragmentProvider.type.name

    fun show(containerId: Int, fragmentManager: FragmentManager, args: Bundle? = null) =
        strategy.show(fragmentProvider, containerId, fragmentManager, args)
}