package com.tim.redux.base.http

import android.content.Context
import android.widget.Toast
import com.tim.redux.ui.App
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Created by pc on 2017/10/19.
 */
class HttpSubscriber<T>(private val context: Context = App.getCurrentActivity(), private val accept:(t:T)->Unit): Subscriber<T>{
    override fun onNext(t: T) {
        accept(t)
    }

    override fun onSubscribe(s: Subscription?) {}

    override fun onComplete() {}

    override fun onError(t: Throwable?) {
        if(t is ApiException) t.message?.toast(context)
    }

    fun String.toast(context: Context){
        Toast.makeText(context,this, Toast.LENGTH_SHORT).show()
    }
}