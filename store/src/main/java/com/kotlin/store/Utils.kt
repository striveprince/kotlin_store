package com.kotlin.store

/**
 * Created by pc on 2017/10/12.
 */
inline fun <reified T> toArray(list: List<*>): T = list.toTypedArray() as T

inline fun <reified T> Iterable<*>.flatMap() = this.filter { it is T }.map { it as T }
