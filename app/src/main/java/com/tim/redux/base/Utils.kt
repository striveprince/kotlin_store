package com.tim.redux.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tim.redux.App
import io.reactivex.Flowable

/**
 * Created by pc on 2017/10/12.
 */
fun <T : Flowable<T>> AppCompatActivity.lifecycle(flowable: Flowable<T>): Flowable<T> {
    return flowable.filter { LifecycleRegistry(this).currentState != Lifecycle.State.DESTROYED }
}
//public final <U, R> Flowable<R> zipWith(Publisher<? extends U> other, BiFunction<? super T, ? super U, ? extends R> zipper) {
//inline fun Activity.relativeLayout(init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): android.widget.RelativeLayout {

// fun<T,U, R> Flowable<T>.zipWith(other:Publisher<in U>,apply:Unit){
//
//}

//fun Throwable.toast(){
//    Toast.makeText(App.app,this.message,Toast.LENGTH_LONG).show()
//}


fun<T> Flowable<T>.pick(pair:Pair<String,Int>){
    return
}

inline fun <reified T> toArray(list: List<*>): T {
    return list.toTypedArray() as T
}

inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>(){}.type)

//    fun <reified T> dispatchData(flowable:Flowable<*>)=
//inline fun <reified T> Flowable<*>.dispatchData():Flowable<T>{
//    return this.filter { it is T }.map { it as T }
//}
inline fun <reified T> Flowable<*>.dispatchData() = this.filter { it is T }.map { it as T }