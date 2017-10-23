package com.tim.compiler.process

import com.tim.compiler.IProcessor
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.tools.StandardLocation

/**
 * Created by pc on 2017/10/21.
 */
class EventProcess : IProcessor {
//    var mFiler: Filer by Delegates.notNull()
//    var mElements: Elements by Delegates.notNull()
//    var mType: Types by Delegates.notNull()
//    var mMessage: Messager by Delegates.notNull()
    private val packageName = ""
    private val className = ""

    override fun process(roundEnv: RoundEnvironment, mAbstractProcessor: AbstractProcessor) {
        mFiler.createResource(StandardLocation.SOURCE_OUTPUT, packageName, "$className.kt")
                .openWriter().use {
        }
    }
}