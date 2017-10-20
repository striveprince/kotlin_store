package com.tim.redux.base.inject.module

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.tim.redux.base.inject.qualifier.activity.ActivityContext
import com.tim.redux.base.inject.qualifier.manager.ActivityFragmentManager
import com.tim.redux.base.inject.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by pc on 2017/10/13.
 */
@Module
class ActivityModule(val activity:Activity){
    @ActivityContext
    @Provides
    @ActivityScope
    internal fun provideActivityContext(): Context {
        return activity
    }

    @Provides
    @ActivityScope
    @ActivityFragmentManager
    internal fun provideFragmentManager(): FragmentManager? {
        return (activity as? FragmentActivity)?.supportFragmentManager
    }



}