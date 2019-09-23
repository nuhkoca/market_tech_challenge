package com.techchallenge.marketim.ui.login

import androidx.lifecycle.LiveData
import com.github.ajalt.timberkt.w
import com.techchallenge.core.BaseViewModel
import com.techchallenge.core.local.BooleanPreference
import com.techchallenge.core.local.LocalStorageModule
import com.techchallenge.core.util.executors.Executors
import com.techchallenge.core.util.ext.applySchedulers
import com.techchallenge.domain.LoginValidateUseCase
import com.techchallenge.domain.LoginValidateUseCase.LoginParams
import com.techchallenge.marketim.vm.SingleLiveEvent
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject
import javax.inject.Named

class LoginViewModel @Inject constructor(
    private val loginValidateUseCase: LoginValidateUseCase,
    @Named(LocalStorageModule.REMEMBER_ME_PREF) private val rememberMePref: BooleanPreference,
    override var executors: Executors
) : BaseViewModel(executors) {

    private val _formValidationLiveData = SingleLiveEvent<Boolean>()
    val formValidationLiveData: LiveData<Boolean> get() = _formValidationLiveData

    fun checkValidation(
        usernameObservable: Observable<String>,
        passwordObservable: Observable<String>
    ) {
        loginValidateUseCase.execute(LoginParams(usernameObservable, passwordObservable))
            .applySchedulers(executors)
            .subscribe(_formValidationLiveData::setValue) {
                w { it.localizedMessage?.toString().toString() }
            }.addTo(disposables)
    }

    fun setRememberMe(isRemember: Boolean) {
        rememberMePref.set(isRemember)
    }
}
