package com.techchallenge.data

import com.google.gson.annotations.SerializedName

data class ProductDetailViewItem(

    @SerializedName("orderDetail")
    val orderDetail: String,
    @SerializedName("summaryPrice")
    val summaryPrice: String
)
