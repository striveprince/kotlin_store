package com.tim.redux.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.multidex.MultiDexApplication
import com.kotlin.store.Params
import com.tim.redux.base.container.ActivityLifecycleCallbacks
import io.reactivex.subjects.PublishSubject
import java.util.*

/**
 * Created by pc on 2017/10/12.
 */
class App : MultiDexApplication(), ActivityLifecycleCallbacks {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        application = this
    }


    companion object {
        val subject = PublishSubject.create<Params>()
        lateinit var application : App
        val app: App by lazy { application }
        private val stack=Stack<Activity>()
        fun getCurrentActivity() = stack.lastElement()!!
//        val appComponent by lazy { DaggerAppComponent.builder().appModule(AppModule(app)).build() }
    }


    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) { stack.add(activity) }
    override fun onActivityDestroyed(activity: Activity?) { stack.remove(activity) }



}

