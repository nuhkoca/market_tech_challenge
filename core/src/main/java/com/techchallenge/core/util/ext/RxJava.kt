package com.techchallenge.core.util.ext

import com.techchallenge.core.util.executors.Executors
import io.reactivex.Completable
import io.reactivex.Flowable
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
