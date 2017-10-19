package com.tim.redux

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.multidex.MultiDexApplication
import com.tim.redux.base.container.Event
import io.reactivex.subjects.PublishSubject
import java.util.*


/**
 * Created by pc on 2017/10/12.
 */
class App : MultiDexApplication(), Application.ActivityLifecycleCallbacks {
    val stack=Stack<Activity>()
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        application = this
    }

    companion object {
        lateinit var application : App
        val app:App by lazy { application }
        val subject = PublishSubject.create<Event>()
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) { stack.add(activity) }
    override fun onActivityDestroyed(activity: Activity?) { stack.remove(activity) }
    override fun onActivityPaused(activity: Activity?) {}
    override fun onActivityResumed(activity: Activity?) {}
    override fun onActivityStarted(activity: Activity?) {}
    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}
    override fun onActivityStopped(activity: Activity?) {}

    fun getCurrentActivity() = stack.lastElement()
}

