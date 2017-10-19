package com.tim.redux.base.inject.component

import android.content.Context
import com.tim.redux.base.inject.module.AppModule
import com.tim.redux.base.inject.module.DataModule
import com.tim.redux.base.inject.module.NetWorkModule
import com.tim.redux.base.inject.qualifier.activity.AppContext
import com.tim.redux.base.inject.scope.AppScope
import dagger.Component

/**
 * Created by pc on 2017/10/13.
 */
@AppScope
@Component(modules =arrayOf(NetWorkModule::class, AppModule::class,DataModule::class))
interface AppComponent {
    @AppContext
    fun context(): Context
//    fun getApiService(): ApiService

}