package com.lhj.function_mudule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.lhj.function_mudule.design.observer.*
import com.lhj.libcommon.Constants
import kotlinx.android.synthetic.main.activity_second.*

@Route(path = "/function/second")
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        tv_title.text = Constants.BASE_URL
        val weatherStation = WeatherStation()
        NoticeBoard.getInstance.register(weatherStation)
        sendData.setOnClickListener{
            weatherStation.setMessage("阴转晴")
        }
//        FamilyDuck().apply {
//            displaySurface()
//            action()
//            swim()
//        }
//        SalineDuck().apply {
//            displaySurface()
//            action()
//            swim()
//        }
    }
}