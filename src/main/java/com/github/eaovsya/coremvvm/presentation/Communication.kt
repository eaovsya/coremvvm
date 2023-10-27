package com.github.eaovsya.coremvvm.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Interface for communication through [LiveData]
 */
interface Communication {

    /**@SelfDocumented*/
    interface Observe<T> {
        fun observe(owner: LifecycleOwner, observer: Observer<T>)
    }

    /**@SelfDocumented*/
    interface Update<T> {
        fun update(data: T)
    }

    /**
     * Communication that can be observed and updated
     */
    interface Mutable<T> : Observe<T>, Update<T>

    /**@SelfDocumented*/
    abstract class Abstract<T : Any>(
        protected val mutableLiveData: MutableLiveData<T>
    ) : Mutable<T> {

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
            mutableLiveData.observe(owner, observer)
        }
    }


    /**@SelfDocumented*/
    abstract class UiUpdate<T : Any>(
        liveData: MutableLiveData<T> = MutableLiveData()
    ) : Abstract<T>(liveData) {

        override fun update(data: T) {
            mutableLiveData.value = data
        }
    }

    /**@SelfDocumented*/
    abstract class PostUpdate<T : Any>(
        liveData: MutableLiveData<T> = MutableLiveData()
    ) : Abstract<T>(liveData) {

        override fun update(data: T) = mutableLiveData.postValue(data)
    }

    /**@SelfDocumented*/
    abstract class SingleUiUpdate<T : Any> : UiUpdate<T>(SingleLiveEvent())

    /**@SelfDocumented*/
    abstract class SinglePostUpdate<T : Any> : PostUpdate<T>(SingleLiveEvent())

    /**@SelfDocumented*/
    class Empty<T> : Mutable<T> {
        override fun update(data: T) = Unit

        override fun observe(owner: LifecycleOwner, observer: Observer<T>) = Unit
    }
}