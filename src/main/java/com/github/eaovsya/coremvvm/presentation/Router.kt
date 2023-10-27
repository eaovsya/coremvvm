package com.github.eaovsya.coremvvm.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentManager

/**
 * Base functionality for navigation
 */
interface Router {

    /**@SelfDocumented*/
    fun showFragment(fragment: FragmentScreen, args: Bundle? = null)

    /**
     * Abstract implementation with the necessary arguments
     */
    abstract class Abstract(
        private val containerId: Int,
        private val fragmentManager: FragmentManager
    ) : Router {

        /**@SelfDocumented*/
        override fun showFragment(fragment: FragmentScreen, args: Bundle?) {
            fragment.show(containerId, fragmentManager, args)
        }
    }
}