package com.techchallenge.core.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object SharedPreferencesModule {

    private const val MARKETIM_SHARED_PREFERENCES = "Marketim"

    @Provides
    @Singleton
    @JvmStatic
    fun provideMarketimPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(MARKETIM_SHARED_PREFERENCES, MODE_PRIVATE)
    }
}
