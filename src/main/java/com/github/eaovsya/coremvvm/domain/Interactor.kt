package com.github.eaovsya.coremvvm.domain

import com.github.eaovsya.coremvvm.core.Dispatchers
import com.github.eaovsya.coremvvm.data.HandleError

/**@SelfDocumented*/
interface Interactor {

    suspend fun <T> handle(
        successful: suspend (T) -> Unit,
        atFinish: suspend () -> Unit,
        block: suspend () -> T
    )

    /**
     * @SelfDocumented
     * @param handleError - when implementing you need to use [UiErrorQualifier] for this parameter
     */
    abstract class Abstract(
        private val dispatchers: Dispatchers,
        private val handleError: HandleError
    ) : Interactor {

        override suspend fun <T> handle(
            successful: suspend (T) -> Unit,
            atFinish: suspend () -> Unit,
            block: suspend () -> T
        ) {
            try {
                val result = block.invoke()
                dispatchers.changeToUI { successful.invoke(result) }
            } catch (error: Exception) {
                handleError.handle(error)
            } finally {
                dispatchers.changeToUI { atFinish.invoke() }
            }
        }
    }
}