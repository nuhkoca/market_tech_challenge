package com.techchallenge.marketim.di.module

import com.techchallenge.marketim.di.scope.ActivityScope
import com.techchallenge.marketim.ui.login.LoginActivity
import com.techchallenge.marketim.ui.orders.OrdersActivity
import com.techchallenge.marketim.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun provideOrdersActivity(): OrdersActivity

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun provideLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun provideSplashActivity(): SplashActivity
}
