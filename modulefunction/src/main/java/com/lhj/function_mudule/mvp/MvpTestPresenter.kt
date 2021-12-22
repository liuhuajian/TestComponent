package com.lhj.function_mudule.mvp

import com.lhj.libbase.base.mvp.BaseMvpActivity
import com.lhj.libbase.base.mvp.BasePresenter
import com.lhj.libbase.utils.MyLogger

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/22 20:04
 * @Version: 0.1
 */
class MvpTestPresenter:BasePresenter<MvpTestControl.View>(),MvpTestControl.Presenter {
    init {
        MyLogger.e("MvpTestPresenter init")
    }

    override fun getData() {
        MyLogger.e("getData")
    }
}