package com.lhj.libcommon.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.lhj.libbase.widget.NoDoubleClickListener

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/14 11:07
 * @Version: 0.1
 */
abstract class BaseActivity :AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 无title
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //全屏
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        bind?.root?.apply {
            setContentView(this)
        }
        initView()
        initListener()
        initData()
    }

    fun setOnClick(vararg views:View){
        views.forEach {
            it.setOnClickListener(this)
        }
    }

    fun setOnDoubleClick(vararg views:View){
        views.forEach {
            it.setOnClickListener(object : NoDoubleClickListener(){
                override fun onNoDoubleClick(v: View) {
                    this@BaseActivity.onClick(v)
                }
            })
        }
    }

    abstract val bind:ViewBinding?

    protected inline fun <reified T> getBind():Lazy<T> where T:ViewBinding{
        return lazy {
            val clazz = T::class.java
            val method = clazz.getMethod("inflate",LayoutInflater::class.java)
            method.invoke(null, layoutInflater) as T
        }
    }

    open fun initListener(){}
    open fun initView(){}
    open fun initData(){}
    override fun onClick(v: View?) {}

}