package com.lhj.lib.util

import android.content.Context
import android.widget.Toast

class ToastUtil {
    companion object{
        val getInstance = ToastUtil()
    }
    fun show(mContext:Context,content:String){
        Toast.makeText(mContext, content,Toast.LENGTH_SHORT).show()
    }
}