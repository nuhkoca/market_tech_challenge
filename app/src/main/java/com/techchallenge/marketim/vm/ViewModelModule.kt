package com.techchallenge.marketim.vm

import androidx.lifecycle.ViewModelProvider
import com.techchallenge.marketim.ui.login.LoginViewModelModule
import com.techchallenge.marketim.ui.orders.OrdersViewModelModule
import com.techchallenge.marketim.ui.splash.SplashViewModelModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [OrdersViewModelModule::class,
        LoginViewModelModule::class,
        SplashViewModelModule::class]
)
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindsMarketimViewModelFactory(viewModelFactory: MarketimViewModelFactory):
            ViewModelProvider.Factory
}
