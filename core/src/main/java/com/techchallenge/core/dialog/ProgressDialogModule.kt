package com.techchallenge.core.dialog

import com.techchallenge.core.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProgressDialogModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun provideProgressDialogFragment(): ProgressDialogFragment
}
