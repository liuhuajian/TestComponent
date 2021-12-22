package com.lhj.libbase.base.mvp

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/22 19:12
 * @Version: 0.1
 */
interface IPresenter<in V:IBaseView> {
    fun attachView(mRootView:V)
    fun detachView()
}