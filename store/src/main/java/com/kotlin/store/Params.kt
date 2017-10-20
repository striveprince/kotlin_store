package com.kotlin.store

/**
 * Created by pc on 2017/10/20.
 */
class Params(
        val group:String,
        val function:String,
        val state: Int = 0,
        val name:String,
        vararg p:Any
){ val params = p }