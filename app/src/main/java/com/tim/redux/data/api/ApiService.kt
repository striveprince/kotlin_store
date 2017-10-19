package com.tim.redux.data.api

import com.tim.redux.data.entity.InfoEntity
import com.tim.redux.data.entity.user.UserEntity
import io.reactivex.Flowable

/**
 * Created by pc on 2017/10/13.
 */
interface ApiService {
    fun getUsers(key:String): Flowable<InfoEntity<UserEntity>>

}