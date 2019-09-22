package com.techchallenge.marketim.ui.splash

import com.techchallenge.core.BaseActivity
import com.techchallenge.core.util.ext.launchActivity
import com.techchallenge.core.util.ext.observeWith
import com.techchallenge.marketim.R
import com.techchallenge.marketim.ui.login.LoginActivity
import com.techchallenge.marketim.ui.orders.OrdersActivity

class SplashActivity : BaseActivity<SplashViewModel>() {

    override val layoutId = R.layout.activity_splash

    override fun getViewModelClass() = SplashViewModel::class.java

    override fun initView() {
        // no-op
    }

    override fun observeViewModel() = with(viewModel) {
        rememberMeLiveData.observeWith(this@SplashActivity) { isRememberMe ->
            if (isRememberMe) {
                launchActivity<OrdersActivity>()
            } else {
                launchActivity<LoginActivity>()
            }
        }
    }
}
