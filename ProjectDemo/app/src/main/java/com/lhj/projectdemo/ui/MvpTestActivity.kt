package com.lhj.projectdemo.ui

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2021/11/10 17:53
 *  @版本0.2
 *  @类说明：
 */
class MvpTestActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(TextView(this).apply {
            text = "liuhuajian"
            setTextColor(Color.BLACK)
        })
    }
}