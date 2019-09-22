package com.techchallenge.core

import com.techchallenge.core.util.executors.ComputationThread
import com.techchallenge.core.util.executors.ExecutionThread
import com.techchallenge.core.util.executors.MarketimComputationThread
import com.techchallenge.core.util.executors.MarketimExecutionThread
import com.techchallenge.core.util.executors.MarketimPostExecutionThread
import com.techchallenge.core.util.executors.PostExecutionThread
import dagger.Binds
import dagger.Module

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
}
