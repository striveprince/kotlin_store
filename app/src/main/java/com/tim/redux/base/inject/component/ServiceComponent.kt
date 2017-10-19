package com.tim.redux.base.inject.component

import com.tim.redux.base.inject.module.ServiceModule
import com.tim.redux.base.inject.scope.ActivityScope
import com.tim.redux.base.inject.scope.ServiceScope
import dagger.Component

/**
 * Created by pc on 2017/10/16.
 */

@ServiceScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ServiceModule::class))
interface ServiceComponent {
}