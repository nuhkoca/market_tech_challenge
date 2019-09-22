package com.techchallenge.marketim

import com.techchallenge.core.BaseApplication
import com.techchallenge.marketim.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MarketimApplication : BaseApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this).also { appComponent ->
            appComponent.inject(this)
        }
}
