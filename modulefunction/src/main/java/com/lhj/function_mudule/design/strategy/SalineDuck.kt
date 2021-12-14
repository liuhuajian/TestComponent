package com.lhj.function_mudule.design.strategy

import android.util.Log

class SalineDuck: Duck(), SpecialAction {
    companion object{
        const val TAG = "SalineDuck"
    }
    override fun action() {
        Log.i(TAG,"我是提供盐水的哦")
    }

    override fun displaySurface() {
        super.displaySurface()
        Log.i(TAG,"我是盐水鸭")
    }

}