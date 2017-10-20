package com.tim.redux.ui.store

import com.kotlin.store.Params

/**
 * Created by pc on 2017/10/20.
 */
object HttpStoreEvent{
    val group=HttpStore::class.simpleName!!
    val getHomeData = "getHomeData"
    val getUserEvent = "getUserEvent"

    fun getHomeDataEvent(state:Int,any: Any): Params {
        return Params(group, getHomeData, state, any::class.simpleName!!)
    }

    fun getUserEvent(state: Int,any: Any,userId:Int): Params {
        return Params(group, getUserEvent, state, any::class.simpleName!!, userId)
    }

}