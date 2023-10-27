package com.github.eaovsya.coremvvm.data

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**@SelfDocumented*/
interface ProvideOkHttpClientBuilder {

    fun httpClientBuilder(): OkHttpClient.Builder

    abstract class Abstract(
        private val interceptorProvider: InterceptorProvider,
        private val timeOutSeconds: Long = DEFAULT_TIMEOUT_SECONDS
    ) : ProvideOkHttpClientBuilder {

        override fun httpClientBuilder() = OkHttpClient.Builder()
            .addInterceptor(interceptorProvider.interceptor())
            .connectTimeout(timeOutSeconds, TimeUnit.SECONDS)
            .readTimeout(timeOutSeconds, TimeUnit.SECONDS)

        companion object {
            private const val DEFAULT_TIMEOUT_SECONDS = 60L
        }
    }

    class Base(
        interceptorProvider: InterceptorProvider,
    ) : Abstract(interceptorProvider)
}