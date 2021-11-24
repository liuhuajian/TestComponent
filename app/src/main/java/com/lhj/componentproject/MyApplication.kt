package com.lhj.componentproject

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.lhj.libbase.base.BaseApplication

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/11/19 20:23
 * @Version: 0.1
 */
class MyApplication:BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        Log.i("MyApplication","on create")
    }
}