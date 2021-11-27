package com.lhj.function_mudule.design.strategy

import android.util.Log

class FamilyDuck: Duck(), SpecialAction {
    companion object{
        const val TAG = "FamilyDuck"
    }
    override fun action() {
        Log.i(TAG,"我会捉虫子")
    }

    override fun displaySurface() {
        super.displaySurface()
        Log.i(TAG,"我是家庭鸭")
    }
}