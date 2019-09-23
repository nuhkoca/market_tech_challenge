package com.techchallenge.marketim.ui.orders

import com.techchallenge.core.BaseActivity
import com.techchallenge.core.util.delegate.ItemAdapter
import com.techchallenge.core.util.ext.init
import com.techchallenge.core.util.ext.isVisible
import com.techchallenge.core.util.ext.launchActivity
import com.techchallenge.core.util.ext.observeWith
import com.techchallenge.core.util.ext.showAlert
import com.techchallenge.marketim.R
import com.techchallenge.marketim.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_orders.btnLogout
import kotlinx.android.synthetic.main.activity_orders.btnOrders
import kotlinx.android.synthetic.main.activity_orders.pbOrders
import kotlinx.android.synthetic.main.activity_orders.rvOrders
import javax.inject.Inject

class OrdersActivity : BaseActivity<OrdersViewModel>() {

    @Inject
    lateinit var itemAdapter: ItemAdapter

    private var shouldUpdate = false

    override val layoutId = R.layout.activity_orders

    override fun getViewModelClass() = OrdersViewModel::class.java

    override val isToolbarEnabled = true

    override fun initView() {
        rvOrders.init(adapter = itemAdapter)
        btnLogout.setOnClickListener {
            showAlert(
                title = getString(R.string.orders_logout_title),
                message = getString(R.string.orders_logout_message),
                positiveButton = Pair(getString(R.string.orders_logout_positive_button), {
                    viewModel.setRememberMe(false)
                    showDialog(getString(R.string.text_logout))
                }),
                negativeButton = Pair(getString(R.string.orders_logout_negative_button), {})
            )
        }
        btnOrders.setOnClickListener {
            viewModel.getOrders()
        }
    }

    override fun observeViewModel() = with(viewModel) {
        ordersLiveData.observeWith(this@OrdersActivity) {
            if (shouldUpdate.not()) {
                itemAdapter.add(it)
                shouldUpdate = true
            } else {
                itemAdapter.update(it)
            }
        }
        logoutLiveData.observeWith(this@OrdersActivity) {
            hideDialog()
            launchActivity<LoginActivity>()
        }
        onProgress.observeWith(this@OrdersActivity) {
            pbOrders.isVisible = it
            rvOrders.isVisible = it.not()
        }
    }
}
