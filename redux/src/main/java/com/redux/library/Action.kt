package com.redux.library

/**
 * Created by arvin on 2017/12/2.
 */
open class Action(var run:Int=0){

    /**
     * the count of the action
     * */
    fun count():Int = run ushr 1


    /**
     * the status of the action running or not
     * */
    fun running():Boolean = run and 1 == 1


    /**
     * start success of not
     * */
    fun start():Boolean{
        if(running())++run
        return running()
    }


    /**
     * end success of not
     * */
    fun end():Boolean{
        if(!running())++run
        return !running()
    }




}