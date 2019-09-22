package com.techchallenge.core.util.observer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_DESTROY
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable

class CompositeObserver constructor(
    private val lifecycle: Lifecycle,
    private val compositeDisposable: CompositeDisposable
) : LifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(ON_DESTROY)
    fun onCompositeClear() {
        compositeDisposable.clear()
        lifecycle.removeObserver(this)
    }
}
