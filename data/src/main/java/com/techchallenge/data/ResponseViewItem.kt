package com.techchallenge.data

data class ResponseViewItem(

    val date: String,
    val month: String,
    val marketName: String,
    val orderName: String,
    val productPrice: Float,
    val productState: ProductState,
    val productDetailRawViewItem: ProductDetailRawViewItem
)
