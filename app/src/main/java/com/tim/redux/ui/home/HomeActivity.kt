package com.tim.redux.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tim.redux.base.container.BaseActivity
import com.tim.redux.base.dispatchData
import com.tim.redux.base.http.HttpSubscriber
import com.tim.redux.data.entity.InfoEntity
import com.tim.redux.data.entity.user.UserEntity
//import com.tim.redux.ui.store.HttpStoreEvent
import com.tim.store.Params
import io.reactivex.Flowable
import org.jetbrains.anko.*

/**
 * Created by pc on 2017/10/12.
 */

class HomeActivity : BaseActivity() {
    private val userId = 50
    private val s by lazy { HttpSubscriber<InfoEntity<HomeDataEntity>> {} }
    private val u by lazy { HttpSubscriber<InfoEntity<UserEntity>> {} }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getContentView().setContentView(this)
//        Flowable.just(0, 1)
//                .map {
//                    when (it) {
//                        0 -> HttpStoreEvent.getHomeDataEvent(it)
//                        else -> HttpStoreEvent.getUserEvent(it,userId)
//                    }
//                }
//                .subscribe(this)
    }

    override fun respond(event: Params, flowable: Flowable<*>) {
        when (event.tag) {
//            HttpStoreEvent.getHomeData ->
//                flowable.dispatchData<InfoEntity<HomeDataEntity>>().subscribe(s)
//            HttpStoreEvent.getUserEvent ->
//                flowable.dispatchData<InfoEntity<UserEntity>>().subscribe(u)
        }
    }

    private fun getContentView() = object : AnkoComponent<AppCompatActivity> {
        override fun createView(ui: AnkoContext<AppCompatActivity>) = with(ui) {
            verticalLayout {
                lparams(matchParent, matchParent)
                button {
                    text = ""
                    width = dip(20)
                    height = dip(30)
                    topPadding = dip(10)
                    top = dip(20)
                }
                textView {
                    text = ""
                    top = 10
                    bottom = 20
                }.lparams(wrapContent, wrapContent)
            }
        }.view()
    }
}
