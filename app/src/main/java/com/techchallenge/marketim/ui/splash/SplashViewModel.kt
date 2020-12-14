package com.techchallenge.marketim.ui.splash

import androidx.lifecycle.LiveData
import com.github.ajalt.timberkt.w
import com.techchallenge.core.BaseViewModel
import com.techchallenge.core.local.BooleanPreference
import com.techchallenge.core.local.LocalStorageModule.REMEMBER_ME_PREF
import com.techchallenge.core.util.executors.Executors
import com.techchallenge.marketim.vm.SingleLiveEvent
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject
import javax.inject.Named

class SplashViewModel @Inject constructor(
    @Named(REMEMBER_ME_PREF) private val rememberMePref: BooleanPreference,
    override var executors: Executors
) : BaseViewModel(executors) {

    private val _rememberMeLiveData = SingleLiveEvent<Boolean>()
    val rememberMeLiveData: LiveData<Boolean> get() = _rememberMeLiveData

    init {
        startTimer()
    }

    private fun startTimer() {
        Observable.timer(DEFAULT_DELAY, MILLISECONDS, executors.computation)
            .observeOn(executors.ui)
            .flatMap { Observable.fromCallable { rememberMePref.get() } }
            .subscribe(
                {
                    _rememberMeLiveData.value = rememberMePref.get()
                },
                {
                    w { it.localizedMessage?.toString().toString() }
                }
            )
            .addTo(disposables)
    }

    companion object {
        private const val DEFAULT_DELAY = 2000L
    }
}
