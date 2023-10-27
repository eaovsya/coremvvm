package com.github.eaovsya.coremvvm.core

import android.content.Context
import androidx.annotation.StringRes

/**@SelfDocumented*/
interface ResourceManager {

    fun string(@StringRes id: Int): String

    class Base(private val context: Context) : ResourceManager {
        override fun string(id: Int) = context.getString(id)
    }
}