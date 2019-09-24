package com.techchallenge.core.util.ext

import android.content.SharedPreferences

fun SharedPreferences.putBoolean(key: String, value: Boolean) {
    edit().putBoolean(key, value).apply()
}

fun SharedPreferences.remove(key: String) {
    edit().remove(key).apply()
}
