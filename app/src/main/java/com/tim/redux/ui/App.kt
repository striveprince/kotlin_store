package com.tim.redux.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.multidex.MultiDexApplication
import com.tim.redux.base.container.ActivityLifecycleCallbacks
import com.tim.redux.base.inject.component.AppComponent
import com.tim.redux.base.inject.component.DaggerAppComponent
import com.tim.redux.base.inject.module.AppModule
import com.tim.redux.data.api.ApiService
import com.tim.redux.ui.store.HttpStore
import com.tim.redux.ui.store.HttpStoreEvent
import com.tim.store.Params
//import HttpStoreEvent
import io.reactivex.subjects.PublishSubject
import java.util.*
import javax.inject.Inject

/**
 * Created by pc on 2017/10/12.
 */
class App : MultiDexApplication(), ActivityLifecycleCallbacks {
    @Inject lateinit var service:ApiService
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        application = this
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.inject(this)
        HttpStoreEvent.register(HttpStore.getInstance(service))
    }
    
    companion object {
        val subject = PublishSubject.create<Params>()
        lateinit var application : App
        val app: App by lazy { application }
        private val stack=Stack<Activity>()
        fun getCurrentActivity() = stack.lastElement()!!
        lateinit var appComponent: AppComponent
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) { stack.add(activity) }
    override fun onActivityDestroyed(activity: Activity?) { stack.remove(activity) }
}

