package com.tim.redux.base.inject.component

import com.tim.redux.base.inject.module.ActivityModule
import com.tim.redux.base.inject.module.FragmentModule
import com.tim.redux.base.inject.scope.ActivityScope
import dagger.Component

/**
 * Created by pc on 2017/10/16.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

}