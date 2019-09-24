package com.techchallenge.marketim.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ajalt.timberkt.w
import com.techchallenge.core.BaseViewModel
import com.techchallenge.core.UseCase.None
import com.techchallenge.core.util.executors.Executors
import com.techchallenge.core.util.ext.applySchedulers
import com.techchallenge.core.util.ext.progressify
import com.techchallenge.data.ResponseViewItem
import com.techchallenge.domain.GetOrdersUseCase
import com.techchallenge.domain.LogoutUseCase
import com.techchallenge.marketim.vm.ActionLiveData
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class OrdersViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase,
    private val logoutUseCase: LogoutUseCase,
    override var executors: Executors
) : BaseViewModel(executors) {

    private val _ordersLiveData = MutableLiveData<List<ResponseViewItem>>()
    val ordersLiveData: LiveData<List<ResponseViewItem>> get() = _ordersLiveData

    private val _logoutLiveData = ActionLiveData()
    val logoutLiveData: LiveData<Unit> get() = _logoutLiveData

    init {
        getOrders()
    }

    fun getOrders() {
        getOrdersUseCase.execute(None())
            .applySchedulers(executors)
            .progressify(this)
            .subscribe(_ordersLiveData::setValue) {
                w { it.printStackTrace().toString() }
            }
            .addTo(disposables)
    }

    fun logout() {
        logoutUseCase.execute()
            .applySchedulers(executors)
            .subscribe({
                _logoutLiveData.call()
            }, { w { "Cannot logout at the moment" } })
            .addTo(disposables)
    }
}
