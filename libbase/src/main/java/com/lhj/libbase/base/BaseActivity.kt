package com.lhj.libbase.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewbinding.ViewBinding
import com.lhj.libbase.utils.ActivityFragmentManager
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
        ActivityFragmentManager.getInstance().addActivity(this)
        initView()
        initListener()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityFragmentManager.getInstance().removeActivity(this)
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

    /**
     * 创建fragment对象实例,避免每个fragment都写newInstance
     *
     * @receiver Context 上下文对象
     * @param args Array<out Pair<String, String>> bundle所需要的key,value
     * @return F fragment 实例
     */
    protected inline fun <reified F : Fragment> Context.newFragment(vararg args: Pair<String, String>): F {
        val bundle = Bundle()
        args.let {
            for (arg in args) {
                bundle.putString(arg.first, arg.second)
            }
        }
        return supportFragmentManager.fragmentFactory.instantiate(classLoader, F::class.java.name)
            .apply {
                arguments = bundle
            } as F
    }


    /**
     * 设置fragment显示，ktx拓展方法,allowStateLoss设置默认true
     * @param   fragmentView 显示fragment的viewId
     * @param   args Array<out Pair<String, String>> bundle所需要的key,value
     * @param   allowStateLoss  默认为true
     */

    protected inline fun <reified RF : Fragment> replaceFragment(
        fragmentView: Int,
        vararg args: Pair<String, String> = arrayOf(),
        allowStateLoss: Boolean = true
    ) {
        supportFragmentManager.commit(allowStateLoss) {
            replace(fragmentView, newFragment<RF>(*args))
        }
    }

    open fun initListener(){}
    open fun initView(){}
    open fun initData(){}
    override fun onClick(v: View?) {}

}