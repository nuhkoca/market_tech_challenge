package com.techchallenge.domain

import com.techchallenge.core.UseCase
import com.techchallenge.core.UseCase.None
import io.reactivex.Completable
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val logoutRepository: LogoutRepository
) : UseCase.CompletableUseCase<None> {

    override fun execute(params: None?): Completable {
        return logoutRepository.logout()
    }
}
