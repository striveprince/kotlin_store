package com.tim.redux.base.container

import android.support.v7.app.AppCompatActivity
import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.view

/**
 * Created by pc on 2017/10/26.
 */
class BaseView: AnkoComponent<AppCompatActivity> {
    override fun createView(ui: AnkoContext<AppCompatActivity>)= with(ui){
        verticalLayout {  }
    }



}