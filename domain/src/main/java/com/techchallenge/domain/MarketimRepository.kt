package com.techchallenge.domain

import com.techchallenge.data.Response
import io.reactivex.Observable

interface MarketimRepository {
    fun getOrders(): Observable<List<Response>>
}
