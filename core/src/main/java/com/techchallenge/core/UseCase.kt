package com.techchallenge.core

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

interface UseCase {
    interface ObservableUseCase<params : Params, T : Any> :
        UseCase {
        fun execute(params: params): Observable<T>
    }

    interface FlowableUseCase<params : Params, T : Any> :
        UseCase {
        fun execute(params: params): Flowable<T>
    }

    interface CompletableUseCase<params : Params> :
        UseCase {
        fun execute(params: params): Completable
    }

    interface SingleUseCase<params : Params, T : Any> :
        UseCase {
        fun execute(params: params): Single<T>
    }

    abstract class Params

    class None : Params()
}
