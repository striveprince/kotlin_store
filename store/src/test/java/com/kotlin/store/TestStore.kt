package com.kotlin.store

import io.reactivex.Flowable

/**
 * Created by pc on 2017/10/18.
 */
class TestStore : Store{

    fun test(state:Int=0, params:String = "p"):Flowable<String>{
         return Flowable.just("$state test function run success $params")
    }

}