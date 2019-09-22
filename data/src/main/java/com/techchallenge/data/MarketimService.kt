package com.techchallenge.data

import io.reactivex.Single
import retrofit2.http.GET

interface MarketimService {

    @GET(".")
    fun getOrders(): Single<List<ResponseRaw>>
}
