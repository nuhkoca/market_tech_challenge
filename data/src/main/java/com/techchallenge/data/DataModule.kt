package com.techchallenge.data

import com.google.gson.FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.techchallenge.data.DataModule.StaticDataModule
import com.techchallenge.data.qualifier.Local
import com.techchallenge.data.qualifier.Remote
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Singleton

@Module(includes = [StaticDataModule::class])
abstract class DataModule {

    @Binds
    @Remote
    abstract fun provideRemoteDataSource(marketimRemoteDataSource: MarketimRemoteDataSource):
        DataSource

    @Binds
    @Local
    abstract fun provideLocalDataSource(marketimLocalDataSource: MarketimLocalDataSource):
        DataSource

    @Module
    object StaticDataModule {

        private const val DEFAULT_TIMEOUT = 60L

        @Provides
        @JvmStatic
        @Singleton
        internal fun provideGson(): Gson {
            return GsonBuilder().apply {
                setFieldNamingPolicy(UPPER_CAMEL_CASE_WITH_SPACES)
                serializeNulls()
                setLenient()
            }.create()
        }

        @Provides
        @JvmStatic
        @Singleton
        internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            return HttpLoggingInterceptor().apply { level = Level.BODY }
        }

        @Provides
        @JvmStatic
        @Singleton
        internal fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
            return OkHttpClient.Builder().apply {
                connectTimeout(DEFAULT_TIMEOUT, SECONDS)
                readTimeout(DEFAULT_TIMEOUT, SECONDS)
                writeTimeout(DEFAULT_TIMEOUT, SECONDS)

                interceptors().add(httpLoggingInterceptor)
            }.build()
        }

        @Provides
        @JvmStatic
        @Singleton
        internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder().apply {
                baseUrl(BuildConfig.baseUrl)
                addConverterFactory(GsonConverterFactory.create(gson))
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                client(okHttpClient)
            }.build()
        }

        @Provides
        @JvmStatic
        @Singleton
        fun provideMarketimService(retrofit: Retrofit): MarketimService = retrofit.create()
    }
}
