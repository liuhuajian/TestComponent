package com.lhj.libbase.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.lhj.libbase.utils.ActivityFragmentManager
import com.lhj.libbase.widget.NoDoubleClickListener

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/17 19:50
 * @Version: 0.1
 */
abstract class BaseFragment:Fragment(),View.OnClickListener {

    abstract val bind: ViewBinding?
    var mContainer: ViewGroup? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ActivityFragmentManager.getInstance().addFragment(this)
        mContainer = container
        return bind?.root
    }

    protected inline fun <reified T> getBind(): Lazy<T> where T : ViewBinding {
        return lazy {
            val clazz = T::class.java
            val method = clazz.getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            )
            method.invoke(null, layoutInflater, mContainer, false) as T
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
        initData()
        getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        ActivityFragmentManager.getInstance().removeFragment(this)
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
                    this@BaseFragment.onClick(v)
                }
            })
        }
    }

    override fun onClick(v: View?) {}

    /**
     * 初始化控件
     */
    open fun initView() {}

    /**
     * 初始化监听事件
     */
    open fun initListener() {}

    /**
     * 初始化数据
     */
    open fun initData() {}

    /**
     * 获取数据
     */
    open fun getData() {}
}