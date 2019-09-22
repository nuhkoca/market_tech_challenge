package com.techchallenge.marketim.di.component

import android.app.Application
import com.techchallenge.core.CoreModule
import com.techchallenge.core.local.LocalStorageModule
import com.techchallenge.core.local.SharedPreferencesModule
import com.techchallenge.data.DataModule
import com.techchallenge.domain.DomainModule
import com.techchallenge.marketim.MarketimApplication
import com.techchallenge.marketim.di.module.ActivityBuilder
import com.techchallenge.marketim.di.module.AppModule
import com.techchallenge.marketim.di.module.ContextModule
import com.techchallenge.marketim.vm.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        ContextModule::class,
        AppModule::class,
        CoreModule::class,
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class,
        SharedPreferencesModule::class,
        LocalStorageModule::class]
)
interface AppComponent : AndroidInjector<MarketimApplication> {

    override fun inject(instance: MarketimApplication?)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
