package com.kotlin.store

import io.reactivex.Flowable
import org.junit.Test

/**
 * Created by pc on 2017/10/18.
 */
class DispatcherTest {

    @Test
    fun callFunction(){
        val group = "TestStore"
        Dispatcher.instance.register(TestStore())
        val event = Params(group, "test", 0, "tag", "params")
        val f :Flowable<String> = Dispatcher.instance.dispatch(event)
        f.subscribe { print(it) }
    }
}