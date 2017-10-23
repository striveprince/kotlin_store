package com.tim.compiler

import com.tim.annotation.Event
import com.tim.compiler.process.*
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement


class AnnotationCompiler : AbstractProcessor() {

//    var mFiler: Filer //文件相关的辅助类
//    var mElements: Elements //元素相关的辅助类
//    var mMessage: Messager //日志相关的辅助类

    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        mFiler = processingEnv.filer
        mElements = processingEnv.elementUtils
        mType = processingEnv.typeUtils
        mMessage = processingEnv.messager
    }

    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
        EventProcess().process(roundEnv, this)
        return false
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latest()
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(Event::class.java.canonicalName)
    }
}
