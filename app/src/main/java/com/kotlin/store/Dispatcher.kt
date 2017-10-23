package com.kotlin.store

import java.util.*
import kotlin.reflect.KFunction
import kotlin.reflect.full.functions

/**
 * Created by pc on 2017/10/13.
 */
class Dispatcher private constructor() {
    private object Builder {
        val dispatcher = Dispatcher()
    }

    companion object {
        private val map = HashMap<String, Store>()
        val instance: Dispatcher by lazy { Builder.dispatcher }
    }

    fun register(vararg store : Store){
        store.forEach { map.put(it::class.simpleName!!,it) }
    }

    fun<T> dispatch(event: Params):T{
        return map[event.group]?.call(event)!!
    }

    private fun check(function: KFunction<*>, event: Params, store:Any) :Boolean{
        if (function.name == event.tag){
            val list = arrayListOf(store,event.state)
            list.addAll(event.params)
            function.call(*list.toArray())
            return true
        }
        return false
    }

    fun test(event: Params):String {
        val store = map[event.group]!!
        store::class.functions
                .forEach { function ->
                    val builder = StringBuilder("fun ")
                    builder.append(function.name)
                    builder.append("(")
                    for (p in function.parameters) {
                        builder.append(" ")
                        builder.append(p.name)
                        builder.append(":")
                        builder.append(p.type)
//                        builder.append(function.typeParameters[i].name)
//                        if(!function.valueParameters.isEmpty()){
//                            builder.append("=")
////                            builder.append(function.valueParameters[i].name)
//                        }
                    }
//                    builder.deleteCharAt(builder.lastIndex)
                    builder.append(")")
                    builder.append(":")
                    builder.append(function.returnType)
                    builder.append("{ body}")
                    if(event.function ==function.name) {
                        val list = arrayListOf(store,event.state)
                        list.addAll(event.params)
                        val arg = list.toArray()
                        function.call(*arg)
                        return builder.toString()
                    }
                }
        return "no such funcation"
    }

}