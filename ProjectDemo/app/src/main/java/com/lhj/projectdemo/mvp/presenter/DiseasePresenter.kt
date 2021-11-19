package com.lhj.projectdemo.mvp.presenter

import com.lhj.projectdemo.base.BasePresenter
import com.lhj.projectdemo.mvp.contract.DiseaseContract

/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2021/11/10 17:57
 *  @版本0.2
 *  @类说明：
 */
class DiseasePresenter: BasePresenter<DiseaseContract.View>() {
    override fun attachView(rootView: DiseaseContract.View) {
        super.attachView(rootView)
    }

    override fun detchView() {
        super.detchView()
    }
}