package com.lhj.libbase.base.mvp

import com.lhj.libbase.utils.MyLogger
import com.lhj.libbase.utils.WeakReferenceHandler
import java.lang.ref.SoftReference

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/22 19:14
 * @Version: 0.1
 */
open class BasePresenter<T:IBaseView>:IPresenter<T> {

    var mRootView: T? = null

    var handler: WeakReferenceHandler? = null

    override fun attachView(mRootView: T) {
        MyLogger.e("---detachView")
        this.mRootView = SoftReference(mRootView).get()
    }

    override fun detachView() {
        MyLogger.e("---detachView")
        mRootView = null
        handler?.removeCallbacksAndMessages(null)
        handler = null
        //保证activity结束时取消所有正在执行的订阅
    }
}