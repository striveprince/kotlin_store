package com.tim.redux.base.inject.module

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.tim.redux.base.inject.qualifier.activity.FragmentContext
import com.tim.redux.base.inject.qualifier.manager.ChildFragmentManager
import com.tim.redux.base.inject.qualifier.manager.SupportFragmentManager
import com.tim.redux.base.inject.scope.FragmentScope

import dagger.Module
import dagger.Provides

/**
 * Created by pc on 2017/10/16.
 */

@Module
@FragmentScope
class FragmentModule(val fragment:Fragment){
    @FragmentScope
    @Provides
    @FragmentContext
    internal fun provideContext(): Context {
        return fragment.activity
    }

    @FragmentScope
    @Provides
    @SupportFragmentManager
    internal fun provideManager(): FragmentManager {
        return fragment.fragmentManager
    }

    @FragmentScope
    @Provides
    @ChildFragmentManager
    internal fun provideChildManager(): FragmentManager {
        return fragment.childFragmentManager
    }

}
