package com.techchallenge.domain

import io.reactivex.Completable

interface LogoutRepository {
    fun logout(): Completable
}
