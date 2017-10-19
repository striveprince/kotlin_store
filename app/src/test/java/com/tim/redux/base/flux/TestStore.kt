package com.tim.redux.base.flux

import io.reactivex.Flowable
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

/**
 * Created by pc on 2017/10/18.
 */
class TestStore :Store,AnkoLogger{

    fun test(state:Int=0,params:String = "p"):Flowable<String>{
         return Flowable.just("test function run success $params")
    }

}