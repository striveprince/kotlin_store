package com.tim.store


/**
 * Created by pc on 2017/10/12.
 */
inline fun <reified T> toArray(list: List<*>): T = list.toTypedArray() as T

inline fun <reified T> Iterable<*>.flatMap() = this.filter { it is T }.map { it as T }
//inline fun<reified T> Store.call(event: Params) :T{
//    val list = arrayListOf(this,event.state)
//    list.addAll(event.params)
//    return  this::class.functions
//            .filter { kFunction -> event.function == kFunction.name }
//            .filter { kFunction -> checkParams(kFunction,event.params)}
////                .filter {  }
//            .single()
//            .call(*list.toArray()) as T
//}