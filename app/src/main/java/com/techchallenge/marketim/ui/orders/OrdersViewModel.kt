package com.techchallenge.marketim.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ajalt.timberkt.w
import com.techchallenge.core.BaseViewModel
import com.techchallenge.core.UseCase.None
import com.techchallenge.core.local.BooleanPreference
import com.techchallenge.core.local.LocalStorageModule
import com.techchallenge.core.util.executors.Executors
import com.techchallenge.core.util.ext.applySchedulers
import com.techchallenge.data.ResponseViewItem
import com.techchallenge.domain.GetOrdersUseCase
import com.techchallenge.marketim.vm.ActionLiveData
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject
import javax.inject.Named

class OrdersViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase,
    @Named(LocalStorageModule.REMEMBER_ME_PREF) private val rememberMePref: BooleanPreference,
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
            .subscribe(_ordersLiveData::setValue) {
                w { it.printStackTrace().toString() }
            }
            .addTo(disposables)
    }

    fun setRememberMe(isRemember: Boolean) {
        rememberMePref.set(isRemember)
        _logoutLiveData.call()
    }
}
