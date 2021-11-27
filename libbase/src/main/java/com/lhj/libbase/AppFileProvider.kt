package com.lhj.libbase

import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.multidex.MultiDex
//import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.lhj.libbase.base.BaseApplication

//import com.tencent.bugly.crashreport.CrashReport
//import com.wanjian.cockroach.Cockroach
//import com.wanjian.cockroach.ExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch


/**
 * 描述 : 避免三方框架使用了FileProvider,三方sdk初始化统一放到ContentProvider中
 */
class AppFileProvider : FileProvider() {

    /**
     * 初始化调用顺序
     * Application的attachBaseContext()->AppFileProvider的onCreate()->Application的attachBaseContext()
     *
     * @return Boolean true
     */
    override fun onCreate(): Boolean {
        thirdInit()
        return super.onCreate()
    }

    /**
     * 三方库初始化
     */
    private fun thirdInit() {
        MultiDex.install(context?.applicationContext)
        initARouter()
//        // DataStore工具类初始化（替代SharedPreferences）
//        DataStoreUtils.init(context?.applicationContext)
        neverCrashInstall()
//        initBugly()
    }

    /**
     * 阿里路由初始化
     */
    private fun initARouter() {
        if (BuildConfig.DEBUG_MODE) {
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(BaseApplication.mContext)
    }

    /**
     * 全局crash处理
     */
    private fun neverCrashInstall() {
//        val toast = Toast.makeText(context, "", Toast.LENGTH_SHORT)
//        Cockroach.install(context?.applicationContext, object : ExceptionHandler() {
//            override fun onUncaughtExceptionHappened(thread: Thread, throwable: Throwable) {
//                Log.e("AndroidRuntime", "--->onUncaughtExceptionHappened:$thread<---", throwable)
//                CrashLog.saveCrashLog(context?.applicationContext, throwable)
//                CoroutineScope(Dispatchers.Main).launch {
//                    toast.setText("出错了")
//                    toast.show()
//                }
//            }
//
//            override fun onBandageExceptionHappened(throwable: Throwable) {
//                throwable.printStackTrace() //打印警告级别log，该throwable可能是最开始的bug导致的，无需关心
//                toast.setText("Cockroach Worked")
//                toast.show()
//            }
//
//            override fun onEnterSafeMode() {
//                Toast.makeText(context, "友好提示", Toast.LENGTH_LONG).show()
////                if (BuildConfig.DEBUG) {
//                // TODO 跳转到自定义界面友好展示
////                }
//            }
//
//            override fun onMayBeBlackScreen(e: Throwable?) {
//                val thread = Looper.getMainLooper().thread
//                Log.e("AndroidRuntime", "--->onUncaughtExceptionHappened:$thread<---", e)
//                // 黑屏时建议直接杀死app
//                ActivityFragmentManager.getInstance().appExit()
//            }
//        })
    }

    /**
     * 初始化腾讯Bugly
     */
    private fun initBugly() {
//        // 获取当前包名
//        val packageName = context?.applicationContext?.packageName
//        // 获取当前进程名
//        val processName = CommonUtils.getProcessName(android.os.Process.myPid())
//        // 设置是否为上报进程
//        val strategy = CrashReport.UserStrategy(context?.applicationContext)
//        strategy.appVersion = CommonUtils.getVersionName(context?.applicationContext)
//        strategy.isUploadProcess = processName == null || processName == packageName
//        CrashReport.initCrashReport(
//            context?.applicationContext,
//            "58ea6414d7",
//            BuildConfig.DEBUG,
//            strategy
//        )
    }
}