package com.techchallenge.core.util.price

import com.techchallenge.core.util.ext.removeNonDigitCharacters
import javax.inject.Inject

class MarketPriceFormatter @Inject constructor() : PriceFormatter {
    override fun format(price: Float?): String {
        return if (price != null) String.format(PATTERN_PRICE, price) else EMPTY
    }

    override fun format(price: String?): String {
        val priceOnlyDigits = price?.removeNonDigitCharacters()
        return if (!priceOnlyDigits.isNullOrEmpty()) {
            format(priceOnlyDigits.replace(DOT, COMMA).toFloat())
        } else {
            EMPTY
        }
    }

    companion object {
        private const val CURRENCY = "TL"
        private const val PATTERN_PRICE = "%.2f $CURRENCY"
        private const val EMPTY = ""
        private const val COMMA = ","
        private const val DOT = "."
    }
}
