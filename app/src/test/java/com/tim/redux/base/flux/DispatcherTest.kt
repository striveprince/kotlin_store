package com.tim.redux.base.flux

import com.tim.redux.base.container.Event
import io.reactivex.Flowable
import org.junit.Test

/**
 * Created by pc on 2017/10/18.
 */
class DispatcherTest {

    @Test
    fun callFunction(){
        val group = "test"
        Dispatcher.instance.register(group,TestStore())
        val event = Event(group,"test",0,"name","params")
        val f :Flowable<String> = Dispatcher.instance.dispatch(event)
        f.subscribe { print(it) }
    }
}