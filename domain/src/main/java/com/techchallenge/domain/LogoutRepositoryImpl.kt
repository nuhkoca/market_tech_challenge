package com.techchallenge.domain

import com.techchallenge.core.local.BooleanPreference
import com.techchallenge.core.local.LocalStorageModule.REMEMBER_ME_PREF
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Named

class LogoutRepositoryImpl @Inject constructor(
    @Named(REMEMBER_ME_PREF) private val rememberMePref: BooleanPreference
) : LogoutRepository {

    override fun logout(): Completable {
        rememberMePref.set(false)
        return Completable.complete()
    }
}
