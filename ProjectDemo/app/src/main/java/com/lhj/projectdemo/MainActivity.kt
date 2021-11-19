package com.lhj.projectdemo

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.lhj.projectdemo.util.MyLogger
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.function.Consumer

@MyAnnotation("liuhuajian")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
        //html控制textview样式
        tv_content.text = Html.fromHtml("<font color='red' size='50'>"+"刘华健"+"</font>"+"<font color='green' size='20'>"+"是个大帅哥"+"</font>",0)
//        getdata(data)
        //RxJava定时器
//        Observable.interval(0,500, TimeUnit.MILLISECONDS)
//            .take(4.toLong())
//            .map<Long> { toLong -> 3 -toLong }.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                MyLogger.e("it-->$it")
//            },{})

        //handler 多线程
//        startApp.setOnClickListener{
//            var count=0
//            object : Thread() {
//                override fun run() {
//                    super.run()
//                    Looper.prepare()
//                    var handler = object :Handler(){
//                        override fun handleMessage(msg: Message) {
//                            super.handleMessage(msg)
//                            if (msg.what ==0x001){
//                                MyLogger.e("what-->"+msg.arg1)
//                            }
//                        }
//                    }
//                    while (count++<30){
//                        sleep(300)
//                        handler.sendMessage(Message().apply {
//                            what = 0x001
//                            arg1 = count
//                        })
//                    }
//                    Looper.loop()
//                }
//            }.start()
//        }
    }

    private val data = arrayOf("hhh","fffff","fewww")
    private fun getdata(vararg data:String){

    }

    private val handler = object :Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what ==0x001){
                tv_content.text = msg.arg1.toString()
            }
        }
    }

    private fun test(){
        val data = arrayOf("hhh","liuhuajian","09778989")
        Observable.create<String>{
            it.onNext("hhh")
            it.onNext("fffff")
                it.onComplete()
        }.subscribe()
    }
}