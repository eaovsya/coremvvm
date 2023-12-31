package com.github.eaovsya.coremvvm.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.github.eaovsya.coremvvm.core.FragmentProvider

/**
 * Specifies strategy that is gonna be used to show a fragment
 */
abstract class ShowStrategy {

    /**@SelfDocumented*/
    abstract fun show(
        fragmentProvider: FragmentProvider,
        containerId: Int,
        fragmentManager: FragmentManager,
        args: Bundle? = null
    )

    object ADD : ShowStrategy() {
        override fun show(
            fragmentProvider: FragmentProvider,
            containerId: Int,
            fragmentManager: FragmentManager,
            args: Bundle?
        ) {
            fragmentManager.beginTransaction()
                .add(containerId, fragmentProvider.provideFragment(args))
                .addToBackStack(fragmentProvider.type.name)
                .commit()
        }
    }

    object REPLACE : ShowStrategy() {
        override fun show(
            fragmentProvider: FragmentProvider,
            containerId: Int,
            fragmentManager: FragmentManager,
            args: Bundle?
        ) {
            fragmentManager.beginTransaction()
                .replace(containerId, fragmentProvider.provideFragment(args))
                .commit()
        }
    }
}