package com.techchallenge.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techchallenge.core.util.executors.Executors
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(protected open var executors: Executors) : ViewModel() {

    protected val disposables: CompositeDisposable = CompositeDisposable()

    val onProgress = MutableLiveData<Boolean>()

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }
}
