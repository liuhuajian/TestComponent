package com.lhj.function_mudule.design.observer

/**
 * 主题实现类
 */
class WeatherStation:Subject {
    private val observers = mutableListOf<Observer>()
    private var message:String?=null
    //该变量可以使观察者更新时可控
    private var isChanged = false
    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun unregisterObserver(observer: Observer) {
        observers.indexOf(observer).takeIf { it!=-1 }?.run {
            observers.remove(observer)
        }
    }

    fun setMessage(message:String){
        this.message = message
        setChanged(true)
        notifyDataChange()
    }

    private fun setChanged(b: Boolean) {
        isChanged = b
    }

    fun getChanged():Boolean{
        return isChanged
    }

    override fun notifyDataChange() {
        if (isChanged) {
            observers.forEach {
                it.update(message)
            }
            isChanged = false
        }
    }
}