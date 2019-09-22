package com.techchallenge.data

import com.techchallenge.core.util.delegate.AdapterItem

data class ResponseViewItem(

    val date: String,
    val month: String,
    val marketName: String,
    val orderName: String,
    val productPrice: String,
    val productState: ProductState,
    val productDetailRawViewItem: ProductDetailRawViewItem
) : AdapterItem
