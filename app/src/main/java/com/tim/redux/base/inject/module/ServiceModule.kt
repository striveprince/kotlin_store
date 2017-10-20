package com.tim.redux.base.inject.module

import android.app.Service
import android.content.Context
import com.tim.redux.base.inject.qualifier.activity.ServiceContext
import com.tim.redux.base.inject.scope.ServiceScope
import dagger.Module
import dagger.Provides

/**
 * Created by pc on 2017/10/16.
 */
@Module
class ServiceModule(val service:Service){
    @Provides
    @ServiceScope
    @ServiceContext
    internal fun provideContext(): Context {
        return service
    }
}