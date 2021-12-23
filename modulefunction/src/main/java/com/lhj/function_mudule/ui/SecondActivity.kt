package com.lhj.function_mudule.ui

import android.content.Intent
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lhj.function_mudule.Algorithm
import com.lhj.function_mudule.databinding.ActivitySecondBinding
import com.lhj.libbase.utils.MyLogger
import com.lhj.libbase.base.BaseActivity
import com.lhj.libcommon.RoutePathConstants
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.experimental.and

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
        calculateBinary()
        var result = Algorithm.addTowNumber(intArrayOf(1,4,6,8,4,5,9),14)
        MyLogger.e("result-->${result[0]}--->${result[1]}")
//        getData()
//        testReflect()
    }

    private fun calculateBinary() {
        val data = byteArrayOf((-116).toByte())
        MyLogger.e("data-->"+(data[0].toInt()and 0xff))

//        MyLogger.e("byte--("+Byte.MIN_VALUE+","+Byte.MAX_VALUE+")")
//        MyLogger.e("char--("+Char.MIN_VALUE+","+Char.MAX_VALUE+")")
//        MyLogger.e("short--("+Short.MIN_VALUE+","+Short.MAX_VALUE+")")
//        MyLogger.e("Int--("+Int.MIN_VALUE+","+Int.MAX_VALUE+")")
    }

    private fun testReflect() {

        val testClass = TestClass("liuhuajian", 11)
        MyLogger.e("testClass-->"+testClass.name+"-----"+testClass.age)
        val declaredField = testClass.javaClass.getDeclaredField("name")
        declaredField.isAccessible = true
        declaredField.set(testClass,"xuyanfei")
        MyLogger.e("testClass-->"+testClass.name+"-----"+testClass.age)
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
                startActivity(Intent(this, MvpTestActivity::class.java))
            }
        }
    }

    private fun foo(): Flow<Int> = flow{
        for (i in 1..3){
            delay(100)
            emit(i)
        }
    }
    fun asFlow() = runBlocking {

        (1..3).asFlow()
            .take(2)
            .collect { value -> value.toString() }

        (1..3).asFlow().collect {
            value -> MyLogger.e("$value")
        }

        (1..3).asFlow()
            .map { transform -> "liuhuajian$transform" }
            .collect { value -> value.toString() }

        (1..3).asFlow()
            .transform {
                emit("hhh")
//                emit(11)
            }
            .collect{
                value ->
            }
    }

    private fun getData(){

        runBlocking {
            launch {
                for (k in 1..3){
                    MyLogger.e("I'm not blocked $k")
                    delay(100)
                }
            }

            foo().collect { value -> MyLogger.e("value-->$value") }
        }

//        newSingleThreadContext("thread1").use { thread1 ->
//            newSingleThreadContext("thread2").use { thread2 ->
//                runBlocking() {
//                    MyLogger.e("thread2")
//                    withContext(thread1){
//
//                    }
//                }
//            }
//        }

//        val time = measureTimeMillis {
//            val one = async(start = CoroutineStart.LAZY) { doSomeThingUsefulOne() }
//            val two = async(start = CoroutineStart.LAZY) { doSomeThingUsefulTwo() }
//            one.start()
//            two.start()
//            MyLogger.e("the answer is${one.await()+two.await()}")
//        }
//        MyLogger.e("Completed in $time ms Thread ${Thread.currentThread().name}")
    }

    suspend fun doSomeThingUsefulOne(): Int {
        delay(1000L)
        return 1000
    }

    suspend fun doSomeThingUsefulTwo():Int{
        delay(1000L)
        return 2000
    }

    private suspend fun doDelay() {
        delay(2000)
        MyLogger.e("coroutineScope--launch-->" + Thread.currentThread().name)
    }

}