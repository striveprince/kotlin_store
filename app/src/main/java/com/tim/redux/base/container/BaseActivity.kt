package com.tim.redux.base.container

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tim.redux.App
import com.tim.redux.base.flux.Dispatcher
import com.tim.redux.data.entity.InfoEntity
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import org.jetbrains.anko.AnkoLogger

/**
 * Created by pc on 2017/10/12.
 */


abstract class BaseActivity : AppCompatActivity(), AnkoLogger, Consumer<Event> {
    val dispatcher = Dispatcher.instance
    val compositeDisposable = CompositeDisposable()//rxBus

    val set = HashSet<Event>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //register the observer
        compositeDisposable.add(App.subject.subscribe(this))
    }

    private fun initData() {
        val group = javaClass.name
                .substring(packageName.length)
                .split(".")
                .first()
    }

    override fun accept(event: Event) {
        if (set.add(event)) {
            val f: Flowable<*> = dispatcher.dispatch(event)
            val flow =  f.flatMap { entity ->
                when (entity) {
                    is InfoEntity<*> -> return@flatMap Flowable.create({ e: FlowableEmitter<Any> ->
                        if (entity.code == 1 && entity.t != null)
                            e.onNext(entity.t)
                        else throw Exception(entity.msg)
                    }, BackpressureStrategy.LATEST)
                    else -> Flowable.just(entity)
                }
            }
            respond(flow)
        }
    }

    abstract fun respond(flowable:Flowable<*>)

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }


}


//abstract class BaseActivity <STORE:Store,CREATOR :ActionCreator>: AppCompatActivity() ,AnkoLogger{
//    val dispatcher = Dispatcher.instance
//    @Inject constructor(val store:STORE,val creator:CREATE)
//    @Inject lateinit var store:STORE
//    @Inject lateinit var creator:CREATOR
//    val flowable: Flowable<Array<String>> by lazy {
//        Flowable.just(arrayOf(""))
//                .filter { lifecycle.currentState != Lifecycle.State.DESTROYED }
//    }
//
//    private val http = Flowable.just(1)
//
//    abstract fun getContentView():AnkoComponent<BaseActivity>
//        flowable.zipWith(http, BiFunction { s: Array<String>, i: Int -> getEmptyAction() })
//                .map { }
//                .subscribe()
//        getContentView().setContentView(this)
//        flowable.flatMap { t -> Flowable.just(t[0]).subscribeOn(Schedulers.io()) }
//        flowable.concatMap { t -> Flowable.just(t[0]).subscribeOn(Schedulers.io()) }



