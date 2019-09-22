package com.techchallenge.core.local

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BooleanPreference @JvmOverloads constructor(
    private val preferences: SharedPreferences,
    private val key: String,
    private val defaultValue: Boolean = false
) : ReadWriteProperty<Any, Boolean> {

    fun get(): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    val isSet: Boolean
        get() = preferences.contains(key)

    fun set(value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    fun delete() {
        preferences.edit().remove(key).apply()
    }

    override fun getValue(thisRef: Any, property: KProperty<*>) = get()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) = set(value)
}
