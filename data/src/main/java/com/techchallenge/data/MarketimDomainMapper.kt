package com.techchallenge.data

import com.techchallenge.core.util.mapper.Mapper
import javax.inject.Inject

class MarketimDomainMapper @Inject constructor() : Mapper<ResponseRaw, Response> {

    override fun invoke(input: ResponseRaw) = with(input) {
        val productDetail = ProductDetail(
            productDetailRaw?.orderDetail,
            productDetailRaw?.summaryPrice
        )

        Response(
            date,
            month,
            marketName,
            orderName,
            productPrice,
            productState,
            productDetail
        )
    }
}
