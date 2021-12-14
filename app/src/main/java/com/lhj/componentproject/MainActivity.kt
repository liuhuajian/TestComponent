package com.lhj.componentproject

import android.util.Log
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.lhj.componentproject.databinding.ActivityMainBinding
import com.lhj.libcommon.Constants
import com.lhj.libcommon.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun initData() {
        super.initData()
        bind.tvTitle.text = Constants.BASE_URL
    }

    override fun initListener() {
        setOnClick(bind.tvTitle)
        setOnDoubleClick(bind.btnGoFunction)
    }

    override fun onClick(v: View?) {
        when(v){
            bind.tvTitle ->{
                Log.i("Tag","tvTitle")
            }
            bind.btnGoFunction ->{
                Log.i("Tag","btnGoFunction")
            }
        }
    }

    override val bind by getBind<ActivityMainBinding>()
}