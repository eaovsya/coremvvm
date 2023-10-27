package com.github.eaovsya.coremvvm.data

/**@SelfDocumented*/
interface HandleError {

    fun handle(error: Exception): Exception
}