package com.techchallenge.marketim.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ajalt.timberkt.w
import com.techchallenge.core.BaseViewModel
import com.techchallenge.core.UseCase.None
import com.techchallenge.core.util.executors.Executors
import com.techchallenge.core.util.ext.applySchedulers
import com.techchallenge.data.ResponseViewItem
import com.techchallenge.domain.GetOrdersUseCase
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class OrdersViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase,
    override var executors: Executors
) : BaseViewModel(executors) {

    private val _ordersLiveData = MutableLiveData<List<ResponseViewItem>>()
    val ordersLiveData: LiveData<List<ResponseViewItem>> get() = _ordersLiveData

    init {
        getOrders()
    }

    private fun getOrders() {
        getOrdersUseCase.execute(None())
            .applySchedulers(executors)
            .subscribe(_ordersLiveData::setValue) {
                w { it.printStackTrace().toString() }
            }
            .addTo(disposables)
    }
}
