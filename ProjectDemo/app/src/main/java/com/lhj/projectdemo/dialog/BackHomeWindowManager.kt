package com.lhj.projectdemo.dialog

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.lhj.projectdemo.R

/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2020/10/21 16:52
 *  @版本0.2
 *  @类说明：
 */
class BackHomeWindowManager private constructor(){
    private var mBackHomeWindow: View? = null
    companion object {
        val instance: BackHomeWindowManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { BackHomeWindowManager() }
    }

    fun showWindow(context: Context){
        if (mBackHomeWindow != null)
            return
        var mWindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val layoutParam = WindowManager.LayoutParams()
        layoutParam.type = if (Build.VERSION.SDK_INT >= 26) WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY else WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
        layoutParam.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        layoutParam.width = 100
        layoutParam.height = 100
        layoutParam.gravity = Gravity.BOTTOM or Gravity.RIGHT
        layoutParam.alpha = 1.0f
        layoutParam.format = PixelFormat.TRANSLUCENT
        layoutParam.y = 34
        layoutParam.x = 34
        mBackHomeWindow = LayoutInflater.from(context).inflate(R.layout.back_home, null)
//        mBackHomeWindow?.findViewById<TextView>(R.id.tv_home)?.setOnClickListener{
//                dismissWindow(context)
//        }
//        Log.e("mBackHomeWindow--->",mBackHomeWindow.toString())
//        mWindowManager.addView(mBackHomeWindow, layoutParam)
    }

    fun dismissWindow(context: Context){
        var mWindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        Log.d("mBackHomeWindow--->", mBackHomeWindow.toString())
        mBackHomeWindow?.takeIf { it.isAttachedToWindow }?.run {
            mWindowManager.removeView(this)
            mBackHomeWindow = null
        }
    }
}