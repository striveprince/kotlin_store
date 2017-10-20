package com.kotlin.store

import kotlin.reflect.KFunction
import kotlin.reflect.full.functions

/**
 * Created by pc on 2017/10/13.
 */
interface Store {
    fun<T> call(event: Params) :T{
        val list = arrayListOf(this,event.state)
        list.addAll(event.params)
        return this::class.functions
                .filter { kFunction -> event.function == kFunction.name }
                .filter { kFunction -> checkParams(kFunction,event.params)}
                .single()
                .call(*list.toArray()) as T
    }

    fun checkParams(kFunction: KFunction<*>, params: Array<out Any>): Boolean {
        kFunction.parameters[0].name
        return params.size <= kFunction.parameters.size
    }

    fun che(kFunction: KFunction<*>, params: Array<out Any>){
        kFunction.parameters[0].name
    }
}