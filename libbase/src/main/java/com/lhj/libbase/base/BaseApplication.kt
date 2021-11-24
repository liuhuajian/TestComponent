package com.lhj.libbase.base

import android.app.Application
import android.content.Context

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/11/24 22:13
 * @Version: 0.1
 */
open class BaseApplication :Application() {
    companion object{
        lateinit var mContext:Application
    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        mContext = this
    }
}