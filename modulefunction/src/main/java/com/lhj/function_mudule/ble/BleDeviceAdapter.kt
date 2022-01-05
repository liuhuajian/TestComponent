package com.lhj.function_mudule.ble

import android.bluetooth.BluetoothDevice
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lhj.function_mudule.R

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/12/24 15:38
 * @Version: 0.1
 */
class BleDeviceAdapter:BaseQuickAdapter<BluetoothDevice, BaseViewHolder>(R.layout.modulefunction_item_ble) {

    override fun convert(holder: BaseViewHolder, item: BluetoothDevice) {

    }
}