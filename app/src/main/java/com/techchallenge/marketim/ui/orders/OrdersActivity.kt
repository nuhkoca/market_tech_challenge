package com.techchallenge.marketim.ui.orders

import android.widget.Toast
import com.techchallenge.core.BaseActivity
import com.techchallenge.core.util.ext.observeWith
import com.techchallenge.marketim.R

class OrdersActivity : BaseActivity<OrdersViewModel>() {

    override val layoutId = R.layout.activity_orders

    override fun getViewModelClass() = OrdersViewModel::class.java

    override val isToolbarEnabled = true

    override fun initView() {

    }

    override fun observeViewModel() {
        viewModel.ordersLiveData.observeWith(this) {
            Toast.makeText(context, it[0].marketName, Toast.LENGTH_LONG).show()
        }
    }
}
