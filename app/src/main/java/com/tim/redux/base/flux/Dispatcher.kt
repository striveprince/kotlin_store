package com.tim.redux.base.flux

import com.tim.redux.base.container.Event
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import kotlin.reflect.KFunction
import kotlin.reflect.full.functions

/**
 * Created by pc on 2017/10/13.
 */
class Dispatcher private constructor() : AnkoLogger {
    private object Builder {
        val dispatcher = Dispatcher()
    }

    companion object {
        private val map = HashMap<String, Store>()
        val instance: Dispatcher by lazy { Builder.dispatcher }
    }

    fun register(group:String,store:Store){
        map.put(group,store)
    }

    fun<T> dispatch(event: Event):T{
        return map[event.group]?.call(event)!!
    }

    fun test(event: Event):String {
        val store = map[event.group]
        if(store == null)return ""
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
                    info { builder.toString() }
                    if(event.function.equals(function.name)) {
                        val list = arrayListOf<Any>(store,event.state)
                        list.addAll(event.params)
                        val arg = list.toArray()
                        function.call(*arg)
                        return builder.toString()
                    }
                }
        return "no such funcation"
    }



    private fun check(function: KFunction<*>, event: Event,store:Any) :Boolean{
        if (function.name == event.name){
            val list = arrayListOf<Any>(store)
            list.addAll(event.params)
            function.call(args = list.toArray())
            return true
        }
        return false
    }

//    fun check(function:,event:Event):Boolean{
//        if(function)
//        return false
//    }

}