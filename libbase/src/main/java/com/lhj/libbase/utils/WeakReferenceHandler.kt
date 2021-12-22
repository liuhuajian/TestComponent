package com.lhj.libbase.utils

import android.os.Handler
import android.os.Message
import com.lhj.libbase.base.mvp.IBaseView
import java.lang.ref.WeakReference

/**
 * 防止持有外部Activity引用造成内存泄露。
 */
abstract class WeakReferenceHandler(reference: IBaseView?) : Handler() {
    private val mReference: WeakReference<IBaseView?> = WeakReference(reference)
    override fun handleMessage(msg: Message) {
        if (mReference.get() == null) return
        handleMessage(mReference.get(), msg)
    }

    protected abstract fun handleMessage(
        reference: IBaseView?,
        msg: Message?
    )

}