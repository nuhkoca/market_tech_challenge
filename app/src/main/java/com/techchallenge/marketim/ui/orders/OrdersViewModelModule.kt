package com.techchallenge.marketim.ui.orders

import androidx.lifecycle.ViewModel
import com.techchallenge.marketim.vm.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class OrdersViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(OrdersViewModel::class)
    abstract fun provideOrdersViewModel(ordersViewModel: OrdersViewModel): ViewModel
}
