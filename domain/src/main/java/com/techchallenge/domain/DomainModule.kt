package com.techchallenge.domain

import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    abstract fun provideMarketimRepository(marketimRepositoryImpl: MarketimRepositoryImpl):
        MarketimRepository

    @Binds
    abstract fun provideLogoutRepository(logoutRepositoryImpl: LogoutRepositoryImpl):
        LogoutRepository
}
