package com.lhj.function_mudule.design.observer

/**
 * 更新数据接口，用于展示变化数据
 */
interface DisplayElement {
    fun display(message:String?)
}