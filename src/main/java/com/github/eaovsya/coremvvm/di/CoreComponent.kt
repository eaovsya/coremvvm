package com.github.eaovsya.coremvvm.di

import android.content.Context
import com.github.eaovsya.coremvvm.core.Dispatchers
import com.github.eaovsya.coremvvm.core.ResourceManager
import com.github.eaovsya.coremvvm.data.HandleError
import com.github.eaovsya.coremvvm.presentation.GlobalErrorCommunication
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, GlobalErrorCommunicationModule::class])
interface CoreComponent {


    fun retrofitBuilder() : Retrofit.Builder

    fun retrofit() : Retrofit

    fun context(): Context

    fun dispatchers(): Dispatchers

    fun resourceManager(): ResourceManager

    fun globalErrorCommunicationObserve(): GlobalErrorCommunication.Observe

    fun globalErrorCommunicationUpdate(): GlobalErrorCommunication.Update

    fun globalErrorCommunicationMutable(): GlobalErrorCommunication.Mutable

    fun mainActivityComponent(): BaseMainActivityComponent.Factory

    @UiErrorQualifier
    fun uiErrorHandler(): HandleError

    @DomainErrorQualifier
    fun domainErrorHandler(): HandleError

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance
            @Named(BASE_URL_KEY) baseUrl: String
        ) : CoreComponent
    }

    companion object {
        internal const val BASE_URL_KEY = "BASE_URL"
    }
}