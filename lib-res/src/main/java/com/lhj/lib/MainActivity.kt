package com.lhj.lib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lhj.lib.util.ToastUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ToastUtil.getInstance.show(this,"hhh")
    }
}