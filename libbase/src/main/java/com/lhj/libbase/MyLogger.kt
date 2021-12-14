package com.lhj.libbase

import android.util.Log
import java.lang.StringBuilder


/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:日志工具类
 * @Author: liuhuajian
 * @CreateDate： 2021/12/14 20:46
 * @Version: 0.1
 */
object MyLogger {
    private const val TAG = "MyLogger"
    fun e(info:String){
        if (!BuildConfig.DEBUG_MODE){
            return
        }
        val infos = StringBuilder()
        infos.append(getFileLineMethod())
        infos.append(info)
        Log.e(TAG,infos.toString())
    }

    fun i(info:String){
        if (!BuildConfig.DEBUG_MODE){
            return
        }
        val infos = StringBuilder()
        infos.append(getFileLineMethod())
        infos.append(info)
        Log.i(TAG,infos.toString())
    }

    fun w(info:String){
        if (!BuildConfig.DEBUG_MODE){
            return
        }
        val infos = StringBuilder()
        infos.append(getFileLineMethod())
        infos.append(info)
        Log.w(TAG,infos.toString())
    }

    fun v(info:String){
        if (!BuildConfig.DEBUG_MODE){
            return
        }
        val infos = StringBuilder()
        infos.append(getFileLineMethod())
        infos.append(info)
        Log.v(TAG,infos.toString())
    }

    private fun getFileLineMethod(): String {
        val traces = Throwable().stackTrace
        val traceElement = traces[2]
        val toStringBuffer = StringBuilder("[")
            .append(traceElement.fileName).append("[")
            .append(traceElement.methodName).append(":")
            .append(traceElement.lineNumber).append("]")
            .append(":")
        return toStringBuffer.toString()
    }
}