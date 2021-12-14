package com.lhj.function_mudule

import com.alibaba.android.arouter.facade.annotation.Route
import com.lhj.function_mudule.databinding.ActivitySecondBinding
import com.lhj.libcommon.base.BaseActivity

@Route(path = "/function/second")
class SecondActivity : BaseActivity() {

    override val bind by getBind<ActivitySecondBinding>()
}