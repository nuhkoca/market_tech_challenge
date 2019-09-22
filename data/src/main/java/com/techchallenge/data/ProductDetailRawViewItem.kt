package com.techchallenge.data

import com.google.gson.annotations.SerializedName

data class ProductDetailRawViewItem(

    @SerializedName("orderDetail")
    val orderDetail: String,
    @SerializedName("summaryPrice")
    val summaryPrice: String
)
