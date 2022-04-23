package com.lhj.libbase.utils

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View

object Tools{
    fun View.setRoundRectBg(color:Int = Color.WHITE, cornerDadius:Float=12f){
        background = GradientDrawable().apply {
            setColor(color)
            cornerRadius = cornerDadius.toFloat()
        }
    }

    fun View.setRoundRectBg(color:Int = Color.WHITE, arraysRadius:Array<Float>){
        background = GradientDrawable().apply {
            setColor(color)
            cornerRadii = arraysRadius.toFloatArray()
        }
    }
}