package com.techchallenge.marketim.ui.login

import com.techchallenge.core.BaseActivity
import com.techchallenge.core.util.ext.hideKeyBoard
import com.techchallenge.core.util.ext.launchActivity
import com.techchallenge.core.util.ext.observeTextChanges
import com.techchallenge.core.util.ext.observeWith
import com.techchallenge.core.util.ext.showAlert
import com.techchallenge.core.util.observer.CompositeObserver
import com.techchallenge.marketim.R
import com.techchallenge.marketim.ui.orders.OrdersActivity
import kotlinx.android.synthetic.main.activity_login.btnLogin
import kotlinx.android.synthetic.main.activity_login.switchRememberMe
import kotlinx.android.synthetic.main.activity_login.tietPwd
import kotlinx.android.synthetic.main.activity_login.tietUsername

class LoginActivity : BaseActivity<LoginViewModel>() {

    override val layoutId = R.layout.activity_login

    override fun getViewModelClass() = LoginViewModel::class.java

    override fun initView() {
        CompositeObserver(lifecycle, compositeDisposable)

        btnLogin.setOnClickListener {
            hideKeyBoard()
            showDialog()

            val usernameDisposable = tietUsername.observeTextChanges()
            val passwordDisposable = tietPwd.observeTextChanges()

            viewModel.checkValidation(usernameDisposable, passwordDisposable)
        }
        switchRememberMe.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setRememberMe(isChecked)
        }
    }

    override fun observeViewModel() = with(viewModel) {
        formValidationLiveData.observeWith(this@LoginActivity) { validationStatus ->
            hideDialog()
            if (validationStatus) {
                launchActivity<OrdersActivity>()
            } else {
                showAlert(
                    title = getString(R.string.login_alert_dialog_title),
                    message = getString(R.string.login_alert_dialog_message),
                    positiveButtonText = getString(R.string.login_alert_dialog_positive_button_text)
                )
            }
        }
    }
}
