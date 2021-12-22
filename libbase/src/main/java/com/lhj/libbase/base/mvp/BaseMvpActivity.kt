package com.lhj.libbase.base.mvp

import com.lhj.libbase.base.BaseActivity
import com.lhj.libbase.base.mvp.proxy.MvpProxyImpl

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/22 19:08
 * @Version: 0.1
 */
abstract class BaseMvpActivity : BaseActivity(),IBaseView {
    private lateinit var mvpProxy:MvpProxyImpl<*>
    override fun initView() {
        super.initView()
        mvpProxy = createProxy()
        mvpProxy.bindPresenter()
    }

    private fun createProxy(): MvpProxyImpl<*> {
        return MvpProxyImpl(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mvpProxy.unBindPresenter()
    }
}