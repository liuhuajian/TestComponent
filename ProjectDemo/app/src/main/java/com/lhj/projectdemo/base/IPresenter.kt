package com.lhj.projectdemo.base

/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2021/11/10 17:42
 *  @版本0.2
 *  @类说明：
 */
interface IPresenter<in V:IBaseView> {
    fun attachView(rootView:V)
    fun detchView()
}