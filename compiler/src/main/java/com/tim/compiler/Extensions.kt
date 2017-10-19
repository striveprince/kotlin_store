package com.tim.compiler

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName
import javax.annotation.processing.Filer
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import kotlin.properties.Delegates
import com.squareup.kotlinpoet.TypeName.Companion.asTypeName
import javax.lang.model.element.Element
import javax.lang.model.element.ExecutableElement

/**
 * Created by pc on 2017/10/18.
 */
val filerUtils:Filer by Delegates.notNull()
val ElementUtils: Elements by Delegates.notNull()
val typeUtils:Types by Delegates.notNull()

val typeActivity by lazy { ElementUtils.getTypeElement("android.app.Activity").asType() }
val typeFragment by lazy { ElementUtils.getTypeElement("android.app.Fragment").asType() }
//val typeSupportFragment by lazy { ElementUtils.getTypeElement("android.support.v4.app.Fragment").asType() }


val typeSupportFragment by lazy {
    try {
        ElementUtils.getTypeElement("android.support.v4.app.Fragment").asType()
    }catch (e:Exception){
        null
    }
}

val activity by lazy { typeActivity.asTypeName() }
val fragment by lazy { typeFragment.asTypeName() }
val supportFragment by lazy { typeSupportFragment?.asTypeName() }


val string = String::class.asTypeName()
val array = ClassName("kotlin","Array")
val stringArray = ParameterizedTypeName.get(array, string)

val build: ClassName = ClassName.Companion("android.os","Build")
val packageManager = ClassName("android.content.pm","PackageManager")

fun ExecutableElement.simpleName():String{
    val simpleName = this.simpleName.toString()
    val index = simpleName.lastIndex
    if (index > 0)
        return simpleName.substring(0, index)
    return simpleName
}

fun <A:Annotation> Element.getChildWithAnnotation(annotationClass: Class<A> ):List<ExecutableElement>{
   return enclosedElements.filter {
        it.getAnnotation(annotationClass) != null
    }.map {
        it as ExecutableElement
    }
}