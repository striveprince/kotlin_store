package com.tim.redux.base.flux

import com.kotlin.store.Dispatcher
import com.kotlin.store.Params
import io.reactivex.Flowable
import org.junit.Test

/**
 * Created by pc on 2017/10/18.
 */
class DispatcherTest {

    @Test
    fun callFunction(){
        val group = "test"
        Dispatcher.instance.register(TestStore())
        val event = Params(group, "test", 0, "name", "params")
        val f :Flowable<String> = Dispatcher.instance.dispatch(event)
        f.subscribe { print(it) }
    }
}