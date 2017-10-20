package com.tim.compiler

import com.tim.annotation.Event
import javax.lang.model.element.ExecutableElement

/**
 * Created by pc on 2017/10/18.
 */
class EventElement(element: ExecutableElement){
    val permissionName = element.getAnnotation(Event::class.java)
    val functionName = element.simpleName()
}