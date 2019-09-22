package com.techchallenge.data

import com.techchallenge.core.util.mapper.Mapper
import com.techchallenge.data.ProductState.INVALID
import javax.inject.Inject

class MarketimViewItemMapper @Inject constructor() : Mapper<Response, ResponseViewItem> {

    override fun invoke(input: Response) = with(input) {
        val productDetailViewItem = ProductDetailRawViewItem(
            productDetail?.orderDetail.toString(),
            productDetail?.summaryPrice ?: 0.0f
        )

        ResponseViewItem(
            date.toString(),
            month.toString(),
            marketName.toString(),
            orderName.toString(),
            productPrice ?: 0.0f,
            productState ?: INVALID,
            productDetailViewItem
        )
    }
}
