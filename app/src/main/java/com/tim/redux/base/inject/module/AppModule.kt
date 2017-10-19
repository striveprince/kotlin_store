package com.tim.redux.base.inject.module

import android.content.Context
import com.tim.redux.App
import com.tim.redux.base.inject.qualifier.activity.AppContext
import com.tim.redux.base.inject.scope.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by pc on 2017/10/16.
 */
@Module
class AppModule (val app:App){

    @AppContext
    @AppScope
    @Provides
    fun provideAppContext():Context{
        return app
    }

}