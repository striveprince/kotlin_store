package com.tim.redux.base.http

/**
 * Created by pc on 2017/10/19.
 */
class ApiException(val code:Int,msg:String=""):Exception(msg)