package com.github.eaovsya.coremvvm.core

import android.os.Bundle
import androidx.fragment.app.Fragment

interface FragmentProvider {

    val type: Class<out Fragment>

    fun provideFragment(args: Bundle? = null): Fragment

    abstract class FragmentProviderAbstract(
        override val type: Class<out Fragment>,
        private val createFragment: () -> Fragment
    ) : FragmentProvider {

        override fun provideFragment(args: Bundle?): Fragment {
            return createFragment().apply {
                arguments = args
            }
        }
    }
}