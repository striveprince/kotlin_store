package com.tim.redux.base.container

import android.support.v7.app.AppCompatActivity
import android.view.View
import org.jetbrains.anko.*

/**
 * Created by pc on 2017/10/26.
 */
class BaseView: AnkoComponent<AppCompatActivity> {
    override fun createView(ui: AnkoContext<AppCompatActivity>)= with(ui){
        verticalLayout {
            button()
        }
    }
}