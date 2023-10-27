package com.github.eaovsya.coremvvm.di

import androidx.fragment.app.Fragment

interface FragmentInjector {

    fun inject()

    class Empty : FragmentInjector {
        override fun inject() = Unit
    }

    class Base(private val injection: () -> Unit) : FragmentInjector {
        override fun inject() {
            injection.invoke()
        }
    }
}

fun Fragment.withInjection(injection: () -> Unit): FragmentInjector {
    return FragmentInjector.Base(injection)
}