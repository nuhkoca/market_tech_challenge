package com.techchallenge.marketim.vm

import androidx.annotation.MainThread

class ActionLiveData : SingleLiveEvent<Unit>() {

    @MainThread
    fun call() {
        value = Unit
    }
}
