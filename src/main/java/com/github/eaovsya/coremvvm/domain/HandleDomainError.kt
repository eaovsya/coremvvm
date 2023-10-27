package com.github.eaovsya.coremvvm.domain

import com.github.eaovsya.coremvvm.data.HandleError
import java.net.UnknownHostException

/**@SelfDocumented*/
class HandleDomainError : HandleError {

    override fun handle(error: Exception) =
        if (error is UnknownHostException)
            NoInternetConnectionException()
        else
            ServiceUnavailableException()
}