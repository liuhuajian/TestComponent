package com.lhj.componentproject

import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.lhj.componentproject.databinding.ActivityMainBinding
import com.lhj.libbase.utils.MyLogger
import com.lhj.libcommon.Constants
import com.lhj.libbase.base.BaseActivity

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
                MyLogger.e("tvTitle")
            }
            bind.btnGoFunction ->{
                ARouter.getInstance()
                    .build("/function/second")
                    .withBoolean("isCreate",true)
                    .navigation()
            }
        }
    }

    override val bind by getBind<ActivityMainBinding>()
}