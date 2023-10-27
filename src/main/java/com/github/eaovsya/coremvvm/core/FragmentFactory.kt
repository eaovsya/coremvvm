package com.github.eaovsya.coremvvm.core

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

abstract class FragmentFactory(
    private val fragmentProviders: Set<FragmentProvider>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return fragmentProviders.firstOrNull {
            it.type.name == className
        }?.provideFragment() ?: super.instantiate(classLoader, className)
    }
}