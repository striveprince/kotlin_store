package com.tim.store

/**
 * Created by pc on 2017/10/20.
 */
class Params(
        val group:String,
        val function:String,
        val tag:String,
        val state: Int = 0,
        vararg p:Any
){ val params = p }