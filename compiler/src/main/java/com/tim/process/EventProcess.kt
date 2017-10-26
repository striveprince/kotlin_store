package com.tim.process

import com.tim.Event
import com.tim.IProcessor
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement

/**
 * Created by pc on 2017/10/21.
 */
class EventProcess : IProcessor {
//    var mFiler: Filer by Delegates.notNull()
//    var mElements: Elements by Delegates.notNull()
//    var mType: Types by Delegates.notNull()
//    var mMessage: Messager by Delegates.notNull()


    override fun process(roundEnv: RoundEnvironment, mAbstractProcessor: AbstractProcessor) {
        roundEnv.getElementsAnnotatedWith(Event::class.java)
                .groupBy { it.enclosingElement }
                .map { EventBuilder(it.key as TypeElement, it.value.map { EventMethod(it as ExecutableElement) }) }
                .map { it.brewKotlin() }
    }
}