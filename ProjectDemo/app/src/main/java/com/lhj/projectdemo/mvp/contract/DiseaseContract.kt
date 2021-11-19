package com.lhj.projectdemo.mvp.contract

import com.lhj.projectdemo.base.IBaseView
import com.lhj.projectdemo.base.IPresenter

/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2021/11/10 17:39
 *  @版本0.2
 *  @类说明：
 */
interface DiseaseContract {
    interface View : IBaseView {
        fun setDiseaseContent()
    }
    interface Presenter:IPresenter<View>{
        fun requestDisease()
    }
}