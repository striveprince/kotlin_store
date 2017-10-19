package com.tim.redux.ui.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.tim.redux.base.container.BaseActivity
import com.tim.redux.base.dispatchData
import com.tim.redux.base.http.HttpSubscriber
import com.tim.redux.data.entity.InfoEntity
import io.reactivex.Flowable
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by pc on 2017/10/12.
 */

class HomeActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getContentView().setContentView(this)

    }

    val s = HttpSubscriber<InfoEntity<HomeDataEntity>>{
        //this is the http result

    }

    override fun respond(flowable: Flowable<*>) {
        flowable.dispatchData<InfoEntity<HomeDataEntity>>()
                .subscribe(s)
    }

    fun getContentView()=object:AnkoComponent<AppCompatActivity>{
        override fun createView(ui: AnkoContext<AppCompatActivity>)= with(ui){
            verticalLayout {
                button{
                    text = ""
                    width = dip(20)
                    height = dip(30)
                    topPadding = dip(10)
                    top = dip(20)
//                    onClick {  }
//                    LinearLayout.LayoutParams
//                    layout()
                }

                textView{
                    text = ""
                    top = 10
                    bottom = 20
                }
            }
        }
    }
}
