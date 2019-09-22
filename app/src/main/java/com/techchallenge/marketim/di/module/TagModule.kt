package com.techchallenge.marketim.di.module

import com.techchallenge.marketim.di.scope.ActivityScope
import com.techchallenge.marketim.ui.orders.OrdersAdapter
import dagger.Module
import dagger.Provides

@Module
object TagModule {

    @ActivityScope
    @Provides
    @JvmStatic
    fun provideOrdersAdapter(
    ): OrdersAdapter = OrdersAdapter()
}
