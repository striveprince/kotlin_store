package com.tim.compiler

import javax.lang.model.element.TypeElement
import com.squareup.kotlinpoet.TypeName.Companion.asTypeName
import com.squareup.kotlinpoet.TypeSpec
import com.tim.annotation.Event

/**
 * Created by pc on 2017/10/18.
 */

// notification the the
class ClassBuilder(val typeElement:TypeElement,val methodElement: List<EventElement>) {
    companion object {
        const val caller = "target"
        const val request = "requestCode"
        const val result = "result"
    }

    //obtain the package name of the typeElement
    val packageName = ElementUtils.getPackageOf(typeElement).qualifiedName.toString()
    val fullName = typeElement.qualifiedName.toString()
    val className by lazy {
        val name = fullName.substring(packageName.length+1)
        val index = name.indexOf(".")
        if(index>0){
           return@lazy name.substring(index+1,name.length)
        }
        name
    }
    val typeTarget = ElementUtils.getTypeElement(fullName).asType()
    val target = typeTarget.asTypeName()

    val event = typeElement.getChildWithAnnotation(Event::class.java)

    fun brewKotlin(){
        val classname = "${className}Event"
        val typeSpec = TypeSpec.objectBuilder(classname)
    }

    fun addProperties(){

    }
}