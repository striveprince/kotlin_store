package com.tim.compiler

import com.google.auto.service.AutoService
import com.tim.annotation.Event
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement


@AutoService(Processor::class)
class AnnotationCompiler:AbstractProcessor(){

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun getSupportedAnnotationTypes(): Set<String> {
        return setOf(Event::class.java.canonicalName)
    }

    /**
     * @return Boolean can provide other processor to use it
     * */
    override fun process(set: MutableSet<out TypeElement>, roundEnvironment: RoundEnvironment): Boolean {
        roundEnvironment.getElementsAnnotatedWith(Event::class.java)//return Set<Element>
                .groupBy { it.enclosingElement } // base on the key split the LinkedHashMap<Element, MutableList<Element>>()
                .map { ClassBuilder(it.key as TypeElement,it.value.map { EventElement(it as ExecutableElement) }) }
                .map { it.brewKotlin() }
        return false
    }
}
