package com.lhj.function_mudule

import androidx.viewbinding.ViewBinding
import com.lhj.function_mudule.databinding.FragmentFirstBinding
import com.lhj.libbase.base.BaseFragment

class FirstFragment:BaseFragment() {
    override val bind by getBind<FragmentFirstBinding>()
}