package com.tim.redux.data

import com.tim.redux.data.entity.InfoEntity
import com.tim.redux.data.entity.user.UserEntity
import io.reactivex.Flowable

/**
 * Created by pc on 2017/10/13.
 */
class DataManager(val local: IDataSource, val remote: IDataSource) {

    fun getUsers(str: String, refresh: Boolean): Flowable<InfoEntity<UserEntity>> {
        if (refresh) return remote.getUsers(str).onErrorResumeNext(local.getUsers(str))
        else return local.getUsers(str).onErrorResumeNext(getUsers(str, true))
    }
}