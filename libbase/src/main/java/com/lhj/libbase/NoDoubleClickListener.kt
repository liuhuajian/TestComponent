package com.lhj.libbase

import android.view.View
import java.util.*

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/14 14:27
 * @Version: 0.1
 */
abstract class NoDoubleClickListener: View.OnClickListener {
    private var lastClickTime = 0L
    private var lastViewId = 0
    companion object{
        const val MIN_CLICK_DELAY_TIME = 1000
    }
    override fun onClick(v: View) {
        val currentTime = Calendar.getInstance().timeInMillis
        if (currentTime - lastClickTime>MIN_CLICK_DELAY_TIME || v.id!=lastViewId){
            lastViewId = v.id
            lastClickTime = currentTime
            onNoDoubleClick(v)
        }
    }
    abstract fun onNoDoubleClick(v: View)
}