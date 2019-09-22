package com.techchallenge.marketim.ui.splash

import androidx.lifecycle.ViewModel
import com.techchallenge.marketim.vm.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun provideLoginViewModel(splashViewModel: SplashViewModel): ViewModel
}
