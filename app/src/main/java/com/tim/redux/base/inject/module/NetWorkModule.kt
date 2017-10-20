package com.tim.redux.base.inject.module

import com.tim.redux.BuildConfig
import com.tim.redux.base.inject.scope.AppScope
import com.tim.redux.data.api.ApiService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
                .connectTimeout(8, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return httpClientBuilder
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
    }

//    @Provides
//    @AppScope
//    fun provideApiService(retrofit: Retrofit): ApiService {
//        return retrofit.create(ApiService::class.java)
//    }

//    @Provides
//    @AppScope
//    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
//        return Retrofit.Builder()
//                .baseUrl("")
//                .callFactory(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//                .build()
//                .create(ApiService::class.java)
//    }

}