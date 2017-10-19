package com.tim.compiler

import com.tim.annotation.Event
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

class AnnotationCompiler:AbstractProcessor(){

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    /**
     * @return Boolean can provide other processor to use it
     * */
    override fun process(set: MutableSet<out TypeElement>, roundEnvironment: RoundEnvironment): Boolean {
        //obtain the annotation in code
        roundEnvironment.getElementsAnnotatedWith(Event::class.java).groupBy {
            it.enclosingElement
        }.map {
            //base on the source code,create the
//            it.
        }
        return false
    }
}
