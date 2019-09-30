package com.techchallenge.data

import com.techchallenge.core.util.mapper.Mapper
import com.techchallenge.core.util.price.PriceFormatter
import com.techchallenge.data.ProductState.INVALID
import javax.inject.Inject

class MarketimViewItemMapper @Inject constructor(
    private val priceFormatter: PriceFormatter
) : Mapper<Response, ResponseViewItem> {

    override fun invoke(input: Response) = with(input) {
        val productDetailViewItem = ProductDetailViewItem(
            productDetail?.orderDetail.toString(),
            priceFormatter.format(productDetail?.summaryPrice)
        )

        ResponseViewItem(
            date.toString(),
            month.toString(),
            marketName.toString(),
            orderName.toString(),
            priceFormatter.format(productPrice),
            productState ?: INVALID,
            productDetailViewItem
        )
    }
}
