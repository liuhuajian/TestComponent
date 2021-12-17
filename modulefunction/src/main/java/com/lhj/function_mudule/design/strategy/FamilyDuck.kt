package com.lhj.function_mudule.design.strategy

import android.util.Log

class FamilyDuck: Duck{
    private val TAG = "FamilyDuck"
    constructor(){
        action = FlyAction()
    }

    fun changeAction(character: Character){
        action = character
    }

    override fun displaySurface() {
        super.displaySurface()
        Log.i(TAG,"我是家庭鸭")
    }
}