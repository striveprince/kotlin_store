package com.tim.redux.base.container

class Event(
        var group:String,
        val function:String,
        val state: Int = 0,
        val name:String,
        vararg p:Any
){ val params = p }