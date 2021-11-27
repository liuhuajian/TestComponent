package com.lhj.function_mudule.design.observer

/**
 * 主题
 */
interface Subject{
    fun registerObserver(observer: Observer)
    fun unregisterObserver(observer: Observer)
    fun notifyDataChange()
}