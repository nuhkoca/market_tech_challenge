package com.techchallenge.marketim.ui.orders

import com.techchallenge.core.util.delegate.DelegateAdapter
import com.techchallenge.marketim.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
object OrdersModule {

    @ActivityScope
    @Provides
    @JvmStatic
    fun provideOrdersAdapterDelegates(
        ordersAdapter: OrdersAdapter
    ): List<DelegateAdapter> {
        return listOf(ordersAdapter)
    }
}
