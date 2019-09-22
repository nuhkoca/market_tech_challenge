package com.techchallenge.data

import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class MarketimRemoteDataSource @Inject constructor(
    private val marketimService: MarketimService,
    private val domainMapper: MarketimDomainMapper
) : DataSource {

    override fun getOrders(): Observable<List<Response>> =
        marketimService.getOrders()
            .map { it }
            .map { it.map(domainMapper::invoke) }
            .toObservable()

    override fun saveOrders(orders: List<Response>): Completable {
        throw UnsupportedOperationException(NOT_IMPLEMENTED_YET)
    }

    companion object {
        private const val NOT_IMPLEMENTED_YET = "Not Implemented Yet"
    }
}
