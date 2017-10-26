package com.tim;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;

public interface IProcessor {
//    AbstractProcessor
    //AnnotationProcessor
    void process(RoundEnvironment roundEnv, AbstractProcessor mAbstractProcessor);
}