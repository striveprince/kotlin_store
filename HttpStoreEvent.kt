package com.tim.redux.ui.store

import com.tim.Event
import com.tim.store.Dispatcher
import com.tim.store.Params

/**
 * Created by pc on 2017/10/20.
 */
object HttpStoreEvent{
    private val group = HttpStore::class.simpleName!!
    val getHomeData = "getHomeData"
    val getUserEvent = "getUserEvent"

    fun register(store:HttpStore){
        Dispatcher.instance.register(store)
    }

    /**
     *  val group:String,
     *  val function:String,
     *  val state: Int = 0,
     *  val name:String,
     *  vararg p:Any
     * */
    fun getHomeDataEvent(state:Int): Params {
        return Params(group, getHomeData, state,group)
    }

    fun getUserEvent(state: Int,userId:Int): Params {
        return Params(group, getUserEvent, state,  group, userId)
    }

}