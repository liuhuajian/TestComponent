package com.lhj.function_mudule

import com.alibaba.android.arouter.facade.annotation.Route
import com.lhj.function_mudule.databinding.ActivitySecondBinding
import com.lhj.libbase.utils.MyLogger
import com.lhj.libcommon.base.BaseActivity
import kotlinx.coroutines.*

@Route(path = "/function/second")
class SecondActivity : BaseActivity() {

    override val bind by getBind<ActivitySecondBinding>()

    override fun initView() {
        super.initView()
        getData()
    }
    private fun getData() = runBlocking {
//        repeat(10){
//            coroutineScope{
//                launch {
//                    delay(1000)
//                    MyLogger.e("launch---"+Thread.currentThread().name)
//                }
//            }
//        }

        coroutineScope {
            launch(Dispatchers.IO) {
                doDelay()
            }
            MyLogger.e("coroutineScope--"+Thread.currentThread().name)
        }
        MyLogger.e("hello--"+Thread.currentThread().name)
//        job.join()
//        MyLogger.e("job--"+Thread.currentThread().name)
    }
    private suspend fun doDelay(){
        delay(2000)
        MyLogger.e("coroutineScope--launch-->"+Thread.currentThread().name)
    }

}