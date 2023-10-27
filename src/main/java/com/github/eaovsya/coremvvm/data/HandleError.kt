package com.github.eaovsya.coremvvm.data

interface HandleError {

    fun handle(error: Exception): Exception
}