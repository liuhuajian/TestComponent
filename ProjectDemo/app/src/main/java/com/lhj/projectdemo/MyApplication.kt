package com.lhj.projectdemo

import android.app.Application
import android.content.Context
import com.iflytek.cloud.SpeechUtility
import com.lhj.projectdemo.util.MyLogger
import com.lhj.projectdemo.util.SpeechCompoundManager

/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2021/1/29 10:08
 *  @版本0.2
 *  @类说明：
 */
class MyApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        val utility = SpeechUtility.createUtility(
            applicationContext,
            String.format("engine_start=ivw,delay_init=0,appid=%s", "5cd2a8c4")
        )
        mContext = this
        MyLogger.e("SpeechUtility-->$utility")
        SpeechCompoundManager.getInstance()
    }

    companion object{
        var mContext:Context?=null
    }
}