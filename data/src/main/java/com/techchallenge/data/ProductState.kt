package com.techchallenge.data

enum class ProductState(val type: String, val color: Int) {
    INVALID("Invalid", R.color.preparing_invalid),
    ON_THE_WAY("Yolda", R.color.preparing_red),
    PREPARING("Hazırlanıyor", R.color.preparing_orange),
    WAITING_FOR_APPROVAL("Onay Bekliyor", R.color.preparing_green);

    companion object {
        private val contents = values()

        fun of(type: String) = contents.firstOrNull { it.type == type } ?: INVALID
    }
}
