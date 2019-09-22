package com.techchallenge.data

import com.google.gson.annotations.SerializedName

enum class ProductState(val type: String, val color: Int) {
    INVALID("Durum bulunamadı", R.drawable.rectange_invalid),
    @SerializedName("Yolda")
    ON_THE_WAY("Yolda", R.drawable.rectange_on_the_way),
    @SerializedName("Hazırlanıyor")
    PREPARING("Hazırlanıyor", R.drawable.rectange_preparing),
    @SerializedName("Onay Bekliyor")
    WAITING_FOR_APPROVAL("Onay Bekliyor", R.drawable.rectange_waiting_for_approval);

    companion object {
        private val contents = values()

        fun of(type: String) = contents.firstOrNull { it.type == type } ?: INVALID
    }
}
