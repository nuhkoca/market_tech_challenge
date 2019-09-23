package com.techchallenge.domain

import com.techchallenge.core.CoreModule.Companion.PASSWORD
import com.techchallenge.core.CoreModule.Companion.USERNAME
import com.techchallenge.core.UseCase.ObservableUseCase
import com.techchallenge.core.UseCase.Params
import com.techchallenge.core.util.validator.Validator
import com.techchallenge.domain.LoginValidateUseCase.LoginParams
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import javax.inject.Inject
import javax.inject.Named

class LoginValidateUseCase @Inject constructor(
    @Named(USERNAME) private val usernameValidator: Validator<String>,
    @Named(PASSWORD) private val passwordValidator: Validator<String>
) : ObservableUseCase<LoginParams, Boolean> {

    override fun execute(params: LoginParams): Observable<Boolean> {
        return Observables.combineLatest(
            params.usernameObservable,
            params.passwordObservable
        ) { username, password ->
            usernameValidator.isValid(username) && passwordValidator.isValid(password)
        }.distinctUntilChanged()
    }

    class LoginParams(
        val usernameObservable: Observable<String>,
        val passwordObservable: Observable<String>
    ) : Params()
}
