package com.github.eaovsya.coremvvm.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentManager

interface Router {

    fun showFragment(fragment: FragmentScreen, args: Bundle? = null)

    abstract class Abstract(
        private val containerId: Int,
        private val fragmentManager: FragmentManager
    ) : Router {

        override fun showFragment(fragment: FragmentScreen, args: Bundle?) {
            fragment.show(containerId, fragmentManager, args)
        }
    }
}