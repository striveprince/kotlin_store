package com.tim.redux.ui.store

import com.kotlin.store.Store
import com.tim.redux.data.api.ApiService
import com.tim.redux.data.entity.InfoEntity
import com.tim.redux.data.entity.user.UserEntity
import com.tim.redux.ui.home.HomeDataEntity
import io.reactivex.Flowable

/**
 * Created by pc on 2017/10/20.
 */


class HttpStore private constructor(private val apiService: ApiService): Store {
    class Builder(apiService: ApiService){
        val store = HttpStore(apiService)
    }

    companion object {
        @Volatile
        private var instance: HttpStore? = null
        fun getInstance(c: ApiService): HttpStore {
            if (instance == null) {
                synchronized(HttpStore::class) {
                    if (instance == null) {
                        instance = Builder(c).store
                    }
                }
            }
            return instance!!
        }
    }

//    @Event
    fun home(){

    }

    fun getHomeData(state:Int): Flowable<InfoEntity<HomeDataEntity>> {
        return apiService.getHomeData("")
    }

    fun getUser(state:Int,userId:Int): Flowable<InfoEntity<UserEntity>> {
        return apiService.getUsers("")
    }
}