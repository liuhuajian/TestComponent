package com.lhj.function_mudule.ui

import android.view.View
import com.lhj.function_mudule.databinding.ActivityMvpTestBinding
import com.lhj.function_mudule.mvp.MvpTestPresenter
import com.lhj.libbase.base.mvp.BaseMvpActivity
import com.lhj.libbase.base.mvp.proxy.InjectPresenter

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/22 20:01
 * @Version: 0.1
 */
class MvpTestActivity:BaseMvpActivity() {
    override val bind by getBind<ActivityMvpTestBinding>()

    @InjectPresenter
    private val mPresenter:MvpTestPresenter? = null

    override fun initView() {
        super.initView()
        setOnClick(bind.tvBtn)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when(v){
            bind.tvBtn ->{
                mPresenter?.getData()
            }
        }
    }
}