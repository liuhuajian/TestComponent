package com.lhj.projectdemo.util

import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.content.Context


/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2021/2/23 17:21
 *  @版本0.2
 *  @类说明：
 */
class ProcessManagerUtils private constructor(){
    /**
     * 检测一个android程序是否在运行
     * @param context
     * @param PackageName
     * @return
     */
    fun isServiceStarted(context: Context, PackageName: String?): Boolean {
        //<uses-permission android:name="android.permission.GET_TASKS"/>
        //https://crazier9527.iteye.com/blog/1476134
        var isStarted = false
        try {
            val mActivityManager =
                context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val intGetTastCounter = 1000
            val mRunningService = mActivityManager.getRunningServices(intGetTastCounter)
            for (amService in mRunningService) {
                if (0 == amService.service.packageName.compareTo(PackageName!!)) {
                    isStarted = true
                    break
                }
            }
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
        return isStarted
    }

    fun isProessRunning(context: Context,serviceName: String): Boolean {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val lists = am.getRunningServices(30)
        for (info in lists) { //判断服务
            if (info.process == serviceName) {
                return true
            }
        }
        return false
    }

    fun isRunBackground(context: Context, proessName: String): Boolean {
        val activityManager = context
            .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val appProcesses = activityManager
            .runningAppProcesses
        for (appProcess in appProcesses) {
            if (appProcess.processName == proessName) {
                return appProcess.importance == RunningAppProcessInfo.IMPORTANCE_BACKGROUND
            }
        }
        return false
    }

        companion object{
        val INSTANCE: ProcessManagerUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { ProcessManagerUtils() }
    }
}