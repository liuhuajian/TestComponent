package com.lhj.projectdemo

import com.lhj.projectdemo.util.MyLogger

/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2021/1/22 20:53
 *  @版本0.2
 *  @类说明：
 */
class Student private constructor(){
    companion object{
        val instance :Student by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){Student()}
    }
    init {
        MyLogger.e("init success")
    }

    fun getName():String{
        return "liuhuajian"
    }

    constructor(name:String, sex:String) : this() {

    }

    constructor(name:String, sex:String,age:Int) : this() {

    }
}