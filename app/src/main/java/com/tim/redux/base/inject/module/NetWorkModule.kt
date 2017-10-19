package com.tim.redux.base.inject.module

import com.tim.redux.BuildConfig
import com.tim.redux.base.inject.scope.AppScope
import com.tim.redux.data.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by pc on 2017/10/13.
 */
@Module
class NetWorkModule {

    @Provides
    @AppScope
    fun provideOkHttpClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return httpClientBuilder
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
    }


}