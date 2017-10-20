//package com.tim.redux.ui.store
//
//import com.kotlin.store.Dispatcher
//import com.kotlin.store.Params
//
///**
// * Created by pc on 2017/10/20.
// */
//object HttpStoreEvent1{
//    val group=HttpStore::class.simpleName!!
//    val getHomeData = "getHomeData"
//    val getUserEvent = "getUserEvent"
//
//    fun register(store:HttpStore){
//        Dispatcher.instance.register(store)
//    }
//
//    /**
//     *  val group:String,
//     *  val function:String,
//     *  val state: Int = 0,
//     *  val name:String,
//     *  vararg p:Any
//     * */
//    fun getHomeDataEvent(state:Int,tag: String = HttpStoreEvent::class.simpleName?:""): Params {
//        return Params(group, getHomeData, state,tag)
//    }
//
//    fun getUserEvent(state: Int,userId:Int): Params {
//        return Params(group, getUserEvent, state,  HttpStoreEvent::class.simpleName?:"", userId)
//    }
//
//}