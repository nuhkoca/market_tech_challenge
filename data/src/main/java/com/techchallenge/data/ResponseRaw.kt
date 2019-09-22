package com.techchallenge.data

import com.google.gson.annotations.SerializedName

data class ResponseRaw(

    @SerializedName("date")
    val date: String?,
    @SerializedName("month")
    val month: String?,
    @SerializedName("marketName")
    val marketName: String?,
    @SerializedName("orderName")
    val orderName: String?,
    @SerializedName("productPrice")
    val productPrice: Float?,
    @SerializedName("productState")
    val productState: ProductState?,
    @SerializedName("productDetail")
    val productDetailRaw: ProductDetailRaw?
)
