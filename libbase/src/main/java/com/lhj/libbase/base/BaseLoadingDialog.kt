package com.lhj.libbase.base

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.widget.ImageView
import com.lhj.libbase.R

/**
 * Copyright (C), 2021-2021，国民集团健康科技有限公司

 * @ProjectName: 舌象一体机
 * @Description: loading dialog
 * @Author: liulei
 * @CreateDate: 2021/9/26 11:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/24 11:37
 * @UpdateRemark: 更新说明
 * @Version: 0.1
 */
class BaseLoadingDialog @JvmOverloads constructor(
    context: Context,
    themeResId: Int = R.style.BaseLoadingDialog,
) : Dialog(context, themeResId) {

    companion object {
        fun build(context: Context): BaseLoadingDialog {
            return BaseLoadingDialog(context).apply {
                setContentView(R.layout.base_loading_dialog)
                setCanceledOnTouchOutside(false)
                setCancelable(true)
            }
        }
    }

    private val mViewLoading by lazy {
        findViewById<ImageView>(R.id.iv_loading).apply {
            setImageResource(R.drawable.base_anim_loading)
        }
    }
    private val mLoadingAni by lazy { mViewLoading.drawable as AnimationDrawable }

    override fun show() {
        super.show()
        mLoadingAni.start()
    }

    override fun dismiss() {
        super.dismiss()
        mLoadingAni.stop()
    }

    override fun cancel() {
        super.cancel()
        mLoadingAni.stop()
    }

}





















