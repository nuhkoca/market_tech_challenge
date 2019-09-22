package com.techchallenge.marketim.di.module

import com.techchallenge.core.util.validator.Validator
import com.techchallenge.marketim.ui.login.PasswordValidator
import com.techchallenge.marketim.ui.login.UsernameValidator
import dagger.Binds
import dagger.Module
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @Singleton
    @Named(USERNAME)
    abstract fun provideUsernameValidator(usernameValidator: UsernameValidator): Validator<String>

    @Binds
    @Singleton
    @Named(PASSWORD)
    abstract fun providePasswordValidator(passwordValidator: PasswordValidator): Validator<String>

    companion object {
        const val USERNAME = "UsernameValidator"
        const val PASSWORD = "PasswordValidator"
    }
}