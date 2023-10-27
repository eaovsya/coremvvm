package com.github.eaovsya.coremvvm.di

import android.content.Context
import com.github.eaovsya.coremvvm.BuildConfig
import com.github.eaovsya.coremvvm.core.Dispatchers
import com.github.eaovsya.coremvvm.core.ResourceManager
import com.github.eaovsya.coremvvm.data.HandleError
import com.github.eaovsya.coremvvm.data.InterceptorProvider
import com.github.eaovsya.coremvvm.data.ProvideConverterFactory
import com.github.eaovsya.coremvvm.data.ProvideOkHttpClientBuilder
import com.github.eaovsya.coremvvm.data.ProvideRetrofitBuilder
import com.github.eaovsya.coremvvm.di.CoreComponent.Companion.BASE_URL_KEY
import com.github.eaovsya.coremvvm.domain.HandleDomainError
import com.github.eaovsya.coremvvm.presentation.GlobalErrorCommunication
import com.github.eaovsya.coremvvm.presentation.HandleUiError
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class CoreModule {

    @Singleton
    @Provides
    fun provideInterceptorProvider(): InterceptorProvider =
        if (BuildConfig.DEBUG) {
            InterceptorProvider.Debug()
        } else {
            InterceptorProvider.Release()
        }

    @Singleton
    @Provides
    fun provideConverterFactoryProvider(): ProvideConverterFactory =
        ProvideConverterFactory.Base()

    @Singleton
    @Provides
    fun provideOkHttpClientBuilderProvider(interceptorProvider: InterceptorProvider): ProvideOkHttpClientBuilder =
        ProvideOkHttpClientBuilder.Base(interceptorProvider)

    @Singleton
    @Provides
    fun provideRetrofitBuilder(
        providerConvertFactory: ProvideConverterFactory,
        httpClientBuilder: ProvideOkHttpClientBuilder
    ): Retrofit.Builder =
        ProvideRetrofitBuilder.Base(providerConvertFactory, httpClientBuilder)
            .provideRetrofitBuilder()

    @Singleton
    @Provides
    fun provideRetrofit(
        retrofitBuilder: Retrofit.Builder,
        @Named(BASE_URL_KEY) baseUrl: String
    ): Retrofit =
        retrofitBuilder.baseUrl(baseUrl).build()

    @Singleton
    @Provides
    fun provideDispatchers(): Dispatchers = Dispatchers.Base()

    @Singleton
    @Provides
    fun provideResourceManager(context: Context): ResourceManager = ResourceManager.Base(context)

    @Singleton
    @Provides
    fun provideGlobalErrorCommunicationBase(): GlobalErrorCommunication.Base =
        GlobalErrorCommunication.Base()

    @Singleton
    @DomainErrorQualifier
    @Provides
    fun provideDomainErrorHandler(): HandleError = HandleDomainError()

    @Singleton
    @UiErrorQualifier
    @Provides
    fun provideUiErrorHandler(
        manageResources: ResourceManager,
        globalErrorCommunication: GlobalErrorCommunication.Update
    ): HandleError = HandleUiError(manageResources, globalErrorCommunication)
}