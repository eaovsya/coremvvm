package com.github.eaovsya.coremvvm.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.github.eaovsya.coremvvm.core.FragmentProvider

/**
 * Class that has the necessary information about fragment and shows it
 */
abstract class FragmentScreen(
    private val fragmentProvider: FragmentProvider,
    private val strategy: ShowStrategy
) {

    override fun toString(): String = fragmentProvider.type.name

    /**@SelfDocumented*/
    fun show(containerId: Int, fragmentManager: FragmentManager, args: Bundle? = null) =
        strategy.show(fragmentProvider, containerId, fragmentManager, args)
}