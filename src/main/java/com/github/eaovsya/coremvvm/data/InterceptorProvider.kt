package com.github.eaovsya.coremvvm.data

import okhttp3.logging.HttpLoggingInterceptor

/**@SelfDocumented*/
interface InterceptorProvider {

    fun interceptor(): HttpLoggingInterceptor

    abstract class Abstract(
        private val loggingLevel: HttpLoggingInterceptor.Level
    ) : InterceptorProvider {

        override fun interceptor() = HttpLoggingInterceptor().apply {
            level = loggingLevel
        }
    }

    class Debug : Abstract(HttpLoggingInterceptor.Level.BODY)

    class Release : Abstract(HttpLoggingInterceptor.Level.NONE)
}