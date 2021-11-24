package com.lhj.componentproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.lhj.libcommon.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_title.text = Constants.BASE_URL
    }

    fun gotoFuction(view: android.view.View) {
        ARouter.getInstance()
            .build("/function/second")
//            .withBoolean("isCreate",true)
            .navigation()
    }
}