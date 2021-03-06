package com.tim.process

import javax.annotation.processing.Filer
import javax.annotation.processing.Messager
import javax.lang.model.element.ExecutableElement
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import kotlin.properties.Delegates

/**
 * Created by pc on 2017/10/21.
 */

var mFiler: Filer by Delegates.notNull()
var mElements: Elements by Delegates.notNull()
var mType: Types by Delegates.notNull()
var mMessage: Messager by Delegates.notNull()

fun ExecutableElement.simpleName():String{
    val simpleName = simpleName.toString()
    val index = simpleName.lastIndexOf("$")
    if (index > 0) {
        return simpleName.substring(0, index)
    }
    return simpleName
}