package com.techchallenge.domain

import com.techchallenge.data.DataSource
import com.techchallenge.data.Response
import com.techchallenge.data.qualifier.Local
import com.techchallenge.data.qualifier.Remote
import io.reactivex.Observable
import javax.inject.Inject

class MarketimRepositoryImpl @Inject constructor(
    @Remote private val remoteDataSource: DataSource,
    @Local private val localDataSource: DataSource
) : MarketimRepository {

    override fun getOrders(): Observable<List<Response>> =
        localDataSource.getOrders()
            .onErrorResumeNext(
                remoteDataSource.getOrders()
                    .doOnNext { orders -> localDataSource.saveOrders(orders) }
            )
}
