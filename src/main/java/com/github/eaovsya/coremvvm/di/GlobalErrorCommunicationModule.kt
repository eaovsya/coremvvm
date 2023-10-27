package com.github.eaovsya.coremvvm.di

import com.github.eaovsya.coremvvm.presentation.GlobalErrorCommunication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class GlobalErrorCommunicationModule {

    @Singleton
    @Binds
    abstract fun provideGlobalErrorCommunicationMutable(globalErrorCommunication: GlobalErrorCommunication.Base):
            GlobalErrorCommunication.Mutable

    @Singleton
    @Binds
    abstract fun provideGlobalErrorCommunicationObserve(globalErrorCommunication: GlobalErrorCommunication.Base):
            GlobalErrorCommunication.Observe

    @Singleton
    @Binds
    abstract fun provideGlobalErrorCommunicationUpdate(globalErrorCommunication: GlobalErrorCommunication.Base):
            GlobalErrorCommunication.Update
}