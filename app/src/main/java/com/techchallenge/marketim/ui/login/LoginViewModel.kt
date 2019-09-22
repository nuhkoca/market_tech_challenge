package com.techchallenge.marketim.ui.login

import androidx.lifecycle.LiveData
import com.github.ajalt.timberkt.w
import com.techchallenge.core.BaseViewModel
import com.techchallenge.core.local.BooleanPreference
import com.techchallenge.core.local.LocalStorageModule
import com.techchallenge.core.util.executors.Executors
import com.techchallenge.core.util.ext.applySchedulers
import com.techchallenge.core.util.validator.Validator
import com.techchallenge.marketim.di.module.AppModule.Companion.PASSWORD
import com.techchallenge.marketim.di.module.AppModule.Companion.USERNAME
import com.techchallenge.marketim.vm.SingleLiveEvent
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject
import javax.inject.Named

class LoginViewModel @Inject constructor(
    @Named(USERNAME) private val usernameValidator: Validator<String>,
    @Named(PASSWORD) private val passwordValidator: Validator<String>,
    @Named(LocalStorageModule.REMEMBER_ME_PREF) private val rememberMePref: BooleanPreference,
    override var executors: Executors
) : BaseViewModel(executors) {

    private val _formValidationLiveData = SingleLiveEvent<Boolean>()
    val formValidationLiveData: LiveData<Boolean> get() = _formValidationLiveData

    fun checkValidation(
        usernameObservable: Observable<String>,
        passwordObservable: Observable<String>
    ) {
        Observables.combineLatest(
            usernameObservable,
            passwordObservable
        ) { username, password ->
            usernameValidator.isValid(username) && passwordValidator.isValid(password)
        }.distinctUntilChanged()
            .applySchedulers(executors)
            .subscribe(_formValidationLiveData::setValue) {
                w { it.localizedMessage?.toString().toString() }
            }.addTo(disposables)
    }

    fun setRememberMe(isRemember: Boolean) {
        rememberMePref.set(isRemember)
    }
}
