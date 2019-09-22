package com.techchallenge.data

data class Response(

    val date: String?,
    val month: String?,
    val marketName: String?,
    val orderName: String?,
    val productPrice: Float?,
    val productState: ProductState?,
    val productDetail: ProductDetail?
)
