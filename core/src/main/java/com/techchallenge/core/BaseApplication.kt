package com.techchallenge.core

import com.github.ajalt.timberkt.Timber
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber.DebugTree
import javax.inject.Inject

abstract class BaseApplication : DaggerApplication(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        setUp()
    }

    abstract override fun applicationInjector(): AndroidInjector<out DaggerApplication>

    override fun androidInjector() = dispatchingAndroidInjector

    private fun setUp() {
        Timber.uprootAll()
        Timber.plant(DebugTree())
    }
}
