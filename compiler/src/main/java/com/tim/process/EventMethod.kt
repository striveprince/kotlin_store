package com.tim.process

import javax.lang.model.element.ExecutableElement

/**
 * Created by pc on 2017/10/24.
 */
class EventMethod (element: ExecutableElement){
    val methodName = element.simpleName()
    val parameters = element.parameters
//    val parameters = element.parameters

}