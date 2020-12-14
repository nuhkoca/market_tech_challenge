package com.techchallenge.marketim.di.module

import com.techchallenge.core.dialog.ProgressDialogModule
import com.techchallenge.marketim.di.scope.ActivityScope
import com.techchallenge.marketim.ui.login.LoginActivity
import com.techchallenge.marketim.ui.orders.OrdersActivity
import com.techchallenge.marketim.ui.orders.OrdersModule
import com.techchallenge.marketim.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            OrdersModule::class, TagModule::class, ProgressDialogModule::class
        ]
    )
    @ActivityScope
    abstract fun provideOrdersActivity(): OrdersActivity

    @ContributesAndroidInjector(modules = [ProgressDialogModule::class])
    @ActivityScope
    abstract fun provideLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    @ActivityScope
    abstract fun provideSplashActivity(): SplashActivity
}
