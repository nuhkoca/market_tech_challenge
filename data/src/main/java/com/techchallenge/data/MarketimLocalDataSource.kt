package com.techchallenge.data

import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class MarketimLocalDataSource @Inject constructor() : DataSource {

    private var cachedOrders: List<Response>? = null

    override fun getOrders(): Observable<List<Response>> {
        if (cachedOrders.isNullOrEmpty()) {
            return Observable.error(IllegalStateException("Orders are empty"))
        }

        return Observable.just(cachedOrders)
    }

    override fun saveOrders(orders: List<Response>): Completable {
        cachedOrders = orders
        return Completable.complete()
    }
}
