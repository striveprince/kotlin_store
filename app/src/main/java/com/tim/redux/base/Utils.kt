package com.tim.redux.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Flowable

/**
 * Created by pc on 2017/10/12.
 */
//public final <U, R> Flowable<R> zipWith(Publisher<? extends U> other, BiFunction<? super T, ? super U, ? extends R> zipper) {
//inline fun Activity.relativeLayout(init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): android.widget.RelativeLayout {

inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>(){}.type)

inline fun <reified T> Flowable<*>.dispatchData() = this.filter { it is T }.map { it as T }

fun <T : Flowable<T>> AppCompatActivity.lifecycle(flowable: Flowable<T>)= flowable.filter { LifecycleRegistry(this).currentState != Lifecycle.State.DESTROYED }

fun <T : Flowable<T>> Flowable<T>.lifecycle(activity: AppCompatActivity)=this.filter { LifecycleRegistry(activity).currentState != Lifecycle.State.DESTROYED }
