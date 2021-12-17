package com.lhj.function_mudule

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.lhj.function_mudule.databinding.FragmentSecondBinding
import com.lhj.libbase.base.BaseFragment
import com.lhj.libbase.base.BaseLoadingDialog

class SecondFragment:BaseFragment() {
    override val bind by getBind<FragmentSecondBinding>()

    override fun initView() {
        super.initView()
        BaseLoadingDialog.build(activity as Context).show()
    }
}