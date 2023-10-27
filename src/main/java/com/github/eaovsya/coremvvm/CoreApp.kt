package com.github.eaovsya.coremvvm

import android.app.Application
import com.github.eaovsya.coremvvm.di.CoreComponent
import com.github.eaovsya.coremvvm.di.CoreComponentProvider
import com.github.eaovsya.coremvvm.di.DaggerCoreComponent

abstract class CoreApp(private val baseURL: String) : Application(), CoreComponentProvider {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext, baseURL)
    }

    override fun provideCoreComponent() = coreComponent
}