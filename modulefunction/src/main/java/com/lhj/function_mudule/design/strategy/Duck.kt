package com.lhj.function_mudule.design.strategy

import android.util.Log

open class Duck {
    private val TAG = "DUCK"

    fun swim(){
        Log.i(TAG,"开始游泳了")
    }

    open fun displaySurface(){

    }

}