package com.lhj.libbase.base.mvp.proxy

import com.lhj.libbase.base.mvp.BasePresenter
import com.lhj.libbase.base.mvp.IBaseView
import com.lhj.libbase.utils.MyLogger

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/22 19:28
 * @Version: 0.1
 */
class MvpProxyImpl<V:IBaseView>:IMvpProxy {
    private var mView: V
    private var mPresenters: ArrayList<BasePresenter<V>>? = null

    constructor(mView: V) {
        this.mView = mView
        mPresenters = ArrayList()
    }

    override fun bindPresenter() {
        var startTime = System.currentTimeMillis()
        mView.javaClass.declaredFields.forEach {
            //获得已经申明的变量，包括私有的
            it.getAnnotation(InjectPresenter::class.java)?.run {
                //获取变量上面的注解类型为InjectPresenter的
                try {
                    val mInjectPresenter = it.type.newInstance() as BasePresenter<V>
                    mInjectPresenter.attachView(mView)
                    it.isAccessible = true
                    it.set(mView, mInjectPresenter)
                    mPresenters?.add(mInjectPresenter)
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                } catch (e: InstantiationException) {
                    e.printStackTrace()
                } catch (e: ClassCastException) {
                    e.printStackTrace()
                    throw RuntimeException("SubClass must extends Class:BasePresenter")
                }
            }
        }
        var endTime = System.currentTimeMillis()
        MyLogger.e("totalTime-->"+(endTime-startTime))
    }

    override fun unBindPresenter() {
        mPresenters?.forEach {
            it.detachView()
        }
        mPresenters?.clear()
        mPresenters = null
    }
}