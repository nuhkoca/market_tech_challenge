package com.techchallenge.core

import com.techchallenge.core.util.executors.ComputationThread
import com.techchallenge.core.util.executors.ExecutionThread
import com.techchallenge.core.util.executors.MarketimComputationThread
import com.techchallenge.core.util.executors.MarketimExecutionThread
import com.techchallenge.core.util.executors.MarketimPostExecutionThread
import com.techchallenge.core.util.executors.PostExecutionThread
import com.techchallenge.core.util.price.MarketPriceFormatter
import com.techchallenge.core.util.price.PriceFormatter
import com.techchallenge.core.util.validator.PasswordValidator
import com.techchallenge.core.util.validator.UsernameValidator
import com.techchallenge.core.util.validator.Validator
import dagger.Binds
import dagger.Module
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class CoreModule {

    @Binds
    internal abstract fun provideExecutionThread(executionThread: MarketimExecutionThread):
        ExecutionThread

    @Binds
    internal abstract fun providePostExecutionThread(postExecutionThread: MarketimPostExecutionThread):
        PostExecutionThread

    @Binds
    internal abstract fun provideComputationThread(computationThread: MarketimComputationThread):
        ComputationThread

    @Binds
    @Singleton
    @Named(USERNAME)
    internal abstract fun provideUsernameValidator(usernameValidator: UsernameValidator):
        Validator<String>

    @Binds
    @Singleton
    @Named(PASSWORD)
    internal abstract fun providePasswordValidator(passwordValidator: PasswordValidator):
        Validator<String>

    @Binds
    @Singleton
    abstract fun providePriceFormatter(marketPriceFormatter: MarketPriceFormatter): PriceFormatter

    companion object {
        const val USERNAME = "UsernameValidator"
        const val PASSWORD = "PasswordValidator"
    }
}
