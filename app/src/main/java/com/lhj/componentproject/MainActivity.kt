package com.lhj.componentproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoFuction(view: android.view.View) {
        ARouter.getInstance()
            .build("/function/second")
//            .withBoolean("isCreate",true)
            .navigation()
    }
}