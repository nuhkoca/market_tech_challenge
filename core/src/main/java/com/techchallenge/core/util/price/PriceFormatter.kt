package com.techchallenge.core.util.price

interface PriceFormatter {
    fun format(price: Float?): String
    fun format(price: String?): String
}
