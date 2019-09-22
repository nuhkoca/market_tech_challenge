package com.techchallenge.core.local

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
object LocalStorageModule {

    const val REMEMBER_ME_PREF = "rememberMePref"

    @Provides
    @Singleton
    @Named(REMEMBER_ME_PREF)
    @JvmStatic
    fun provideRememberMePref(sharedPreferences: SharedPreferences): BooleanPreference {
        return BooleanPreference(sharedPreferences, REMEMBER_ME_PREF, defaultValue = false)
    }
}
