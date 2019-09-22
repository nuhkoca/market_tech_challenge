package com.techchallenge.core.util.ext

import com.techchallenge.core.BaseViewModel
import com.techchallenge.core.util.executors.Executors
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

fun <T> Observable<T>.applySchedulers(executors: Executors): Observable<T> {
    return subscribeOn(executors.io)
        .observeOn(executors.ui)
}

fun <T> Flowable<T>.applySchedulers(executors: Executors): Flowable<T> {
    return subscribeOn(executors.io)
        .observeOn(executors.ui)
}

fun Completable.applySchedulers(executors: Executors): Completable {
    return subscribeOn(executors.io)
        .observeOn(executors.ui)
}

fun <T> Single<T>.applySchedulers(executors: Executors): Single<T> {
    return subscribeOn(executors.io)
        .observeOn(executors.ui)
}

fun <T> Single<T>.progressify(baseViewModel: BaseViewModel): Single<T> {
    return this.doOnSubscribe { baseViewModel.onProgress.value = true }
        .doOnEvent { _, _ -> baseViewModel.onProgress.value = false }
}

fun <T> Maybe<T>.progressify(baseViewModel: BaseViewModel): Maybe<T> {
    return this.doOnSubscribe { baseViewModel.onProgress.value = true }
        .doOnEvent { _, _ -> baseViewModel.onProgress.value = false }
}

fun Completable.progressify(baseViewModel: BaseViewModel): Completable {
    return this.doOnSubscribe { baseViewModel.onProgress.value = true }
        .doOnEvent { baseViewModel.onProgress.value = false }
}

fun <T> Observable<T>.progressify(baseViewModel: BaseViewModel): Observable<T> {
    return this.doOnSubscribe { baseViewModel.onProgress.value = true }
        .doOnTerminate { baseViewModel.onProgress.value = false }
}
