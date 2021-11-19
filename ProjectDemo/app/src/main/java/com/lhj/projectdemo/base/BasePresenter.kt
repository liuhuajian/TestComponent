package com.lhj.projectdemo.base

/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2021/11/10 17:48
 *  @版本0.2
 *  @类说明：
 */
open class BasePresenter<T : IBaseView> : IPresenter<T> {
    override fun attachView(rootView: T) {

    }

    override fun detchView() {

    }
}