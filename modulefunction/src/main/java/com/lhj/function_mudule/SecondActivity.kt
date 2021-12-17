package com.lhj.function_mudule

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lhj.function_mudule.databinding.ActivitySecondBinding
import com.lhj.libbase.utils.MyLogger
import com.lhj.libbase.base.BaseActivity
import com.lhj.libcommon.RoutePathConstants
import kotlinx.coroutines.*

@Route(path = RoutePathConstants.MODULE_FUNCTION_MAIN)
class SecondActivity : BaseActivity() {

    override val bind by getBind<ActivitySecondBinding>()

    private var data = getMessage()
    private var data1: String? = null
        get() = getMessage()

    private fun getMessage(): String {
        MyLogger.e("getMessage")
        return "hhh"
    }

    override fun initView() {
        super.initView()
        setOnClick(bind.btnOne, bind.btnTwo)
//        getData()
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            bind.btnOne -> {
                ARouter.getInstance()
                    .build(RoutePathConstants.MODULE_FUNCTION_SETTING_MAIN)
                    .withBoolean("isCreate",true)
                    .navigation()
            }
            bind.btnTwo -> {
                data1 =="hhh"
            }
        }
    }

    private fun getData() = runBlocking {
        val job = launch {
            repeat(100) {
                launch {
                    delay(500)
                    MyLogger.e("launch---" + Thread.currentThread().name)
                }
            }
        }
        delay(2000)
//        coroutineScope {
//            launch(Dispatchers.IO) {
//                doDelay()
//            }
//            MyLogger.e("coroutineScope--"+Thread.currentThread().name)
//        }
        MyLogger.e("delay--" + Thread.currentThread().name)
        job.cancelAndJoin()
        MyLogger.e("hello--" + Thread.currentThread().name)
//        job.join()
//        MyLogger.e("job--"+Thread.currentThread().name)
    }

    private suspend fun doDelay() {
        delay(2000)
        MyLogger.e("coroutineScope--launch-->" + Thread.currentThread().name)
    }

}