package com.github.eaovsya.coremvvm.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

/**
 * Implementation of [FragmentFactory] for fragments with arguments
 * Implementations of this class need to replace fragment manager's fragment factory before super.onCreate
 */
abstract class FragmentFactory(
    private val fragmentProviders: Set<FragmentProvider>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return fragmentProviders.firstOrNull {
            it.type.name == className
        }?.provideFragment() ?: super.instantiate(classLoader, className)
    }
}