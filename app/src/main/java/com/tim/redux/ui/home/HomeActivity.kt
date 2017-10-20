package com.tim.redux.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.store.Params
import com.tim.redux.base.container.BaseActivity
import com.tim.redux.base.dispatchData
import com.tim.redux.base.http.HttpSubscriber
import com.tim.redux.data.entity.InfoEntity
import com.tim.redux.data.entity.user.UserEntity
import com.tim.redux.ui.store.HttpStoreEvent
import io.reactivex.Flowable
import org.jetbrains.anko.*

/**
 * Created by pc on 2017/10/12.
 */

class HomeActivity : BaseActivity() {
    val userId = 50
    val s by lazy { HttpSubscriber<InfoEntity<HomeDataEntity>>{} }
    val u by lazy { HttpSubscriber<InfoEntity<UserEntity>> {} }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getContentView().setContentView(this)
        accept(HttpStoreEvent.getHomeDataEvent(0, this))
        accept(HttpStoreEvent.getUserEvent(0, this,userId))
    }


    override fun respond(event: Params, flowable: Flowable<*>) {
        when (event.name) {
            HttpStoreEvent.getHomeData ->
                flowable.dispatchData<InfoEntity<HomeDataEntity>>().subscribe(s)
            HttpStoreEvent.getUserEvent ->
                flowable.dispatchData<InfoEntity<UserEntity>>().subscribe(u)
        }
    }

    fun getContentView() = object : AnkoComponent<AppCompatActivity> {
        override fun createView(ui: AnkoContext<AppCompatActivity>) = with(ui) {
            verticalLayout {
                button {
                    text = ""
                    width = dip(20)
                    height = dip(30)
                    topPadding = dip(10)
                    top = dip(20)
//                    onClick {  }
//                    LinearLayout.LayoutParams
//                    layout()
                }

                textView {
                    text = ""
                    top = 10
                    bottom = 20
                }
            }
        }
    }
}
