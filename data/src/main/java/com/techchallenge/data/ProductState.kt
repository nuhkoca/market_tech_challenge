package com.techchallenge.data

enum class ProductState(val type: String, val color: Int) {
    INVALID("Invalid", R.drawable.rectange_invalid),
    ON_THE_WAY("Yolda", R.drawable.rectange_on_the_way),
    PREPARING("Hazırlanıyor", R.drawable.rectange_preparing),
    WAITING_FOR_APPROVAL("Onay Bekliyor", R.drawable.rectange_waiting_for_approval);

    companion object {
        private val contents = values()

        fun of(type: String) = contents.firstOrNull { it.type == type } ?: INVALID
    }
}
