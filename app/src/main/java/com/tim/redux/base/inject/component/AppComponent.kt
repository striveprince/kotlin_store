package com.tim.redux.base.inject.component

import android.content.Context
import com.tim.redux.base.inject.module.AppModule
import com.tim.redux.base.inject.module.NetWorkModule
import com.tim.redux.base.inject.qualifier.activity.AppContext
import com.tim.redux.base.inject.scope.AppScope
import com.tim.redux.ui.App
import dagger.Component

/**
 * Created by pc on 2017/10/20.
 */

@AppScope
@Component(modules = arrayOf(AppModule::class,NetWorkModule::class))
interface AppComponent {

    @AppScope
    @AppContext
    fun context(): Context

    fun inject(app: App)
}