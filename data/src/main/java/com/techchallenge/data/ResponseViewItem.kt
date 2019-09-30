package com.techchallenge.data

import com.techchallenge.core.util.delegate.AdapterItem

data class ResponseViewItem(

    val date: String,
    val month: String,
    val marketName: String,
    val orderName: String,
    val productPrice: String,
    val productState: ProductState,
    val productDetailViewItem: ProductDetailViewItem
) : AdapterItem {

    private var isExpanded = false

    fun setIsExpanded(isExpanded: Boolean) {
        this.isExpanded = isExpanded
    }

    fun getIsExpanded() = isExpanded

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as ResponseViewItem

        if (marketName != other.marketName) return false

        return true
    }

    override fun hashCode(): Int {
        return marketName.hashCode()
    }
}
