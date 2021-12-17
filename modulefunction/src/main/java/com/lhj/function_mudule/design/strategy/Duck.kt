package com.lhj.function_mudule.design.strategy

import android.util.Log

open class Duck {
    private val TAG = "DUCK"
    protected var action:Character?=null

    fun swim(){
        Log.i(TAG,"开始游泳了")
    }

    fun action(){
        action?.action()
    }

    open fun displaySurface(){

    }

}