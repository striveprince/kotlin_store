package com.tim.annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(value = AnnotationRetention.SOURCE)
annotation class Event(val values:Array<String>)
