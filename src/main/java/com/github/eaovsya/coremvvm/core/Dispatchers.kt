package com.github.eaovsya.coremvvm.core

import kotlinx.coroutines.*

/**
 * Interface to work with coroutines with needed dispatchers
 */
interface Dispatchers {

    /**@SelfDocumented*/
    fun launchUI(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job

    /**@SelfDocumented*/
    fun launchBackground(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit): Job

    /**@SelfDocumented*/
    suspend fun changeToUI(block: suspend CoroutineScope. () -> Unit)

    abstract class Abstract(
        private val ui: CoroutineDispatcher,
        private val background: CoroutineDispatcher,
    ) : Dispatchers {

        override fun launchUI(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit
        ): Job = scope.launch(ui, block = block)

        override fun launchBackground(
            scope: CoroutineScope,
            block: suspend CoroutineScope.() -> Unit
        ): Job = scope.launch(background, block = block)

        override suspend fun changeToUI(block: suspend CoroutineScope. () -> Unit) =
            withContext(ui, block)
    }

    class Base : Abstract(kotlinx.coroutines.Dispatchers.Main, kotlinx.coroutines.Dispatchers.IO)
}