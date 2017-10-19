package com.tim.redux.base.flux

import com.tim.redux.base.container.Event
import io.reactivex.Flowable
import kotlin.reflect.KFunction
import kotlin.reflect.full.functions
import kotlin.reflect.full.valueParameters

/**
 * Created by pc on 2017/10/13.
 */
interface Store {
    fun<T> call(event: Event) :T{
        val list = arrayListOf<Any>(this,event.state)
        list.addAll(event.params)
        return this::class.functions
                .filter { kFunction -> event.function == kFunction.name }
                .filter { kFunction -> checkParams(kFunction,event.params)}
                .single()
                .call(*list.toArray()) as T
    }

    fun checkParams(kFunction: KFunction<*>, params: Array<out Any>): Boolean {
        kFunction.parameters[0].kind
        return params.size <= kFunction.parameters.size
    }
}
