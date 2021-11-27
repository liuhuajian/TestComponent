package com.lhj.function_mudule.design.observer

import android.util.Log

/**
 * 观察者实现类
 */
class NoticeBoard:Observer,DisplayElement {
    companion object{
         val getInstance:NoticeBoard by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { NoticeBoard() }
    }
    private var subject:Subject?=null

    fun register(subject: Subject){
        this.subject = subject
        this.subject?.registerObserver(this)
    }

    fun unregister(){
        subject?.unregisterObserver(this)
    }
    override fun update(message: String?) {
        display("天气预报-->$message")
    }

    override fun display(message: String?) {
        Log.i("NoticeBoard",message!!)
    }
}