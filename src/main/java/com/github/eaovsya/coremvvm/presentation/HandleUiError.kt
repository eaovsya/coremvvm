package com.github.eaovsya.coremvvm.presentation

import androidx.annotation.StringRes
import com.github.eaovsya.coremvvm.core.ResourceManager
import com.github.eaovsya.coremvvm.data.HandleError
import com.github.eaovsya.coremvvm.R
import com.github.eaovsya.coremvvm.domain.NoInternetConnectionException
import com.github.eaovsya.coremvvm.domain.ServiceUnavailableException

/**@SelfDocumented*/
abstract class HandleUiErrorAbstract(
    private val resourceManager: ResourceManager,
    private val globalErrorCommunication: GlobalErrorCommunication.Update,
    private val handleError: HandleError = HandleGenericUiError(
        resourceManager,
        globalErrorCommunication
    )
) : HandleError {

    @StringRes
    protected open val noConnectionExceptionMessage: Int = R.string.no_connection_exception_text

    @StringRes
    protected open val serviceUnavailableExceptionMessage: Int = R.string.no_service_exception_text

    override fun handle(error: Exception): Exception {
        val messageId = when (error) {
            is NoInternetConnectionException -> noConnectionExceptionMessage
            is ServiceUnavailableException -> serviceUnavailableExceptionMessage
            else -> 0
        }
        return if (messageId == 0)
            handleError.handle(error)
        else {
            globalErrorCommunication.update(resourceManager.string(messageId))
            error
        }
    }
}

/**@SelfDocumented*/
class HandleGenericUiError(
    private val manageResources: ResourceManager,
    private val globalErrorCommunication: GlobalErrorCommunication.Update
) : HandleError {

    override fun handle(error: Exception): Exception {
        globalErrorCommunication.update(manageResources.string(R.string.unexpected_error_message))
        return error
    }
}

/**@SelfDocumented*/
class HandleUiError(
    manageResources: ResourceManager,
    globalErrorCommunication: GlobalErrorCommunication.Update
) : HandleUiErrorAbstract(manageResources, globalErrorCommunication)