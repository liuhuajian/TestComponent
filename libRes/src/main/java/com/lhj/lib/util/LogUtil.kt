package com.lhj.lib.util

import android.util.Log

class LogUtil private constructor(){
    companion object{
        val getInstance = LogUtil()
    }

    fun showMesg(tag:String, message:String){
        Log.e(tag,message)
    }
}