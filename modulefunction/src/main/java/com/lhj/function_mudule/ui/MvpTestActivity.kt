package com.lhj.function_mudule.ui

import android.view.View
import com.lhj.function_mudule.bean.Student
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

    private var callback : (() -> Unit)?=null
    private var feedback :(Int, Int) ->Int = {a,b ->callbackhh()}
    private val arrays = arrayOf("hhh","eee","yyy")

    private fun getStudentName(vararg data:String):Student{
        return Student()
    }

    private fun getStudent(student: Student):Student{
        return Student()
    }

    private fun callbackhh(): Int {
        return 10
    }

    val test = {a : Int , b : Int -> a + b}

    private fun judgeIsHHH(element:String):Boolean{
        return element =="hhh"
    }

    override fun initView() {
        super.initView()
        getStudentName(*arrays)
        var list = mutableListOf("hhh","eee","ggg")
        list.filter(::judgeIsHHH)
        setOnClick(bind.tvBtn)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when(v){
            bind.tvBtn ->{
                mPresenter?.getData()
                bind.tvBtn.viewTreeObserver.addOnDrawListener {  }
            }
        }
    }

}