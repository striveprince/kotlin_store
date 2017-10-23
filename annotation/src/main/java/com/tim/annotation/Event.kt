package com.tim.annotation

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy


@Target(AnnotationTarget.FUNCTION)
@Retention(RetentionPolicy.SOURCE)

//@Target(AnnotationTarget.FUNCTION)
//@Retention(AnnotationRetention.SOURCE)
annotation class Event
