package com.tim.redux.data

import com.tim.redux.data.entity.InfoEntity
import com.tim.redux.data.entity.user.UserEntity
import io.reactivex.Flowable

/**
 * Created by pc on 2017/10/13.
 */
interface IDataSource {
    fun getUsers(str:String): Flowable<InfoEntity<UserEntity>>
}