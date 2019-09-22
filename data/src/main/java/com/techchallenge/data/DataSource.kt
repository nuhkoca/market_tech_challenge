package com.techchallenge.data

import io.reactivex.Completable
import io.reactivex.Observable

interface DataSource {
    fun getOrders(): Observable<List<Response>>
    fun saveOrders(orders: List<Response>): Completable
}
