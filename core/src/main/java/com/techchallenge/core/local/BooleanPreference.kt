package com.techchallenge.core.local

import android.content.SharedPreferences
import com.techchallenge.core.util.ext.putBoolean
import com.techchallenge.core.util.ext.remove
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
        preferences.putBoolean(key, value)
    }

    fun delete() {
        preferences.remove(key)
    }

    override fun getValue(thisRef: Any, property: KProperty<*>) = get()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) = set(value)
}
