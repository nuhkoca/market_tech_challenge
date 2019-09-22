package com.techchallenge.marketim.ui.orders

import com.techchallenge.core.BaseActivity
import com.techchallenge.core.util.delegate.ItemAdapter
import com.techchallenge.core.util.ext.init
import com.techchallenge.core.util.ext.observeWith
import com.techchallenge.marketim.R
import kotlinx.android.synthetic.main.activity_orders.rvOrders
import javax.inject.Inject

class OrdersActivity : BaseActivity<OrdersViewModel>() {

    @Inject
    lateinit var itemAdapter: ItemAdapter

    override val layoutId = R.layout.activity_orders

    override fun getViewModelClass() = OrdersViewModel::class.java

    override val isToolbarEnabled = true

    override fun initView() {
        rvOrders.init(adapter = itemAdapter)
    }

    override fun observeViewModel() {
        viewModel.ordersLiveData.observeWith(this, itemAdapter::add)
    }
}
