package com.lhj.function_mudule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.lhj.libcommon.Constants
import kotlinx.android.synthetic.main.activity_second.*

@Route(path = "/function/second")
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        tv_title.text = Constants.BASE_URL
        lifecycle.addObserver(LifecycleListener())
    }
}