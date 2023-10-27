package com.github.eaovsya.coremvvm.di

import com.github.eaovsya.coremvvm.presentation.BaseMainActivity
import dagger.Subcomponent

@Subcomponent
interface BaseMainActivityComponent {

    fun inject(activity: BaseMainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): BaseMainActivityComponent
    }
}