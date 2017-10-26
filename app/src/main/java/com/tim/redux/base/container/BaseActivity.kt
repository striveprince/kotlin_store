package com.tim.redux.base.container

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tim.redux.ui.App
import com.tim.store.Dispatcher
import com.tim.store.Params
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.setContentView

/**
 * Created by pc on 2017/10/12.
 */


abstract class BaseActivity : AppCompatActivity(), AnkoLogger, Consumer<Params> {
    private val dispatcher = Dispatcher.instance
    private val compositeDisposable = CompositeDisposable()//rxBus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentView().setContentView(this)
        compositeDisposable.add(App.subject.subscribe(this))
    }

    private fun contentView(): AnkoComponent<BaseActivity> = BaseView()

//    private fun getContentView() = object : AnkoComponent<AppCompatActivity> {
//        override fun createView(ui: AnkoContext<AppCompatActivity>) = with(ui) {
//            verticalLayout {
//                button {
//                    text = ""
//                    width = dip(20)
//                    height = dip(30)
//                    topPadding = dip(10)
//                    top = dip(20)
////                    onClick {  }
////                    LinearLayout.LayoutParams
////                    layout()
//                }
//
//                textView {
//                    text = ""
//                    top = 10
//                    bottom = 20
//                }
//            }
//        }.view()
//    }

    override fun accept(event: Params) {
            val f: Flowable<*> = dispatcher.dispatch(event)
//            val flow =  f.flatMap { entity ->
//                when (entity) {
//                    is InfoEntity<*> -> return@flatMap Flowable.create({e: FlowableEmitter<Any> ->
//                        if (entity.code == 1 && entity.t != null)
//                            e.onNext(entity.t)
//                        else throw Exception(entity.msg)
//                    }, BackpressureStrategy.LATEST)
//                    else -> Flowable.just(entity)
//                }
//            }
            respond(event,f)
    }

    abstract fun respond(event: Params, flowable:Flowable<*>)

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



