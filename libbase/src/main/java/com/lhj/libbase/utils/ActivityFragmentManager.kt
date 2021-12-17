package com.lhj.libbase.utils

import android.util.Log
import com.lhj.libbase.base.BaseActivity
import com.lhj.libbase.base.BaseFragment
import java.lang.ref.WeakReference
import java.util.*
import kotlin.system.exitProcess

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName: 应用Activity、fragment管理类
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/17 19:50
 * @Version: 0.1
 */
class ActivityFragmentManager private constructor() {

    companion object {

        @Volatile
        private var fragmentStack = Stack<WeakReference<BaseFragment>>()

        @Volatile
        private var activityStack = Stack<WeakReference<BaseActivity>>()

        /**
         * 获得单例对象
         *
         * @return ActivityFragmentManager
         */
        fun getInstance(): ActivityFragmentManager {
            return ActivityFragmentManagerHolder.mInstance
        }
    }

    private object ActivityFragmentManagerHolder {
        val mInstance: ActivityFragmentManager = ActivityFragmentManager()
    }

    /**
     * 获取当前的Fragment
     */
    val currentFragment: BaseFragment?
        get() = if (fragmentStack.size > 0) fragmentStack.lastElement().get() else null

    /**
     * 添加 Fragment
     *
     * @param fragment Fragment
     */
    fun addFragment(fragment: BaseFragment) {
        fragmentStack.add(WeakReference(fragment))
    }

    /**
     * 移除 Fragment
     *
     * @param fragment Fragment
     */
    fun removeFragment(fragment: BaseFragment?) {
        if (fragment == null) {
            return
        }
        for (fragmentRef in fragmentStack) {
            if (fragmentRef.get() == fragment) {
                fragmentStack.remove(fragmentRef)
                break
            }
        }
    }

    /**
     * 获取当前的Activity
     */
    val currentActivity: BaseActivity?
        get() = if (activityStack.size > 0) activityStack.lastElement().get() else null

    /**
     * 添加 Activity
     *
     * @param activity Activity
     */
    fun addActivity(activity: BaseActivity) {
        activityStack.add(WeakReference(activity))
    }

    /**
     * 移除 Activity
     *
     * @param activity Activity
     */
    fun removeActivity(activity: BaseActivity?) {
        if (activity == null) {
            return
        }
        for (activityRef in activityStack) {
            if (activityRef.get() == activity) {
                activityStack.remove(activityRef)
                break
            }
        }
    }

    /**
     * 结束指定Activity
     *
     * @param activity Activity
     */
    fun finishActivity(activity: BaseActivity?) {
        if (activity == null) {
            return
        }
        for (activityRef in activityStack) {
            if (activityRef.get() == activity) {
                activityStack.remove(activityRef)
                break
            }
        }
        activity.finish()
    }

    /**
     * 结束指定Activity
     *
     * @param cls Activity.class
     */
    fun finishActivity(cls: Class<*>?) {
        if (cls == null) {
            return
        }
        for (activityRef in activityStack) {
            if (activityRef.get()?.javaClass == cls) {
                activityStack.remove(activityRef)
                finishActivity(activityRef.get())
                break
            }
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        while (!activityStack.isEmpty()) {
            activityStack.pop().get()?.finish()
        }
        activityStack.clear()
    }

    /**
     * 退出应用程序
     */
    fun appExit() {
        try {
            finishAllActivity()
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(0)
        } catch (e: Exception) {
            Log.e("ActivityFragmentManager", "appExit exception: " + e.message)
        }
    }
}
