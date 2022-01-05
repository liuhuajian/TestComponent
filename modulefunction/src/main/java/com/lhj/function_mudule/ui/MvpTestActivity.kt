package com.lhj.function_mudule.ui

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.View
import com.lhj.function_mudule.databinding.ActivityMvpTestBinding
import com.lhj.function_mudule.mvp.MvpTestPresenter
import com.lhj.libbase.base.mvp.BaseMvpActivity
import com.lhj.libbase.base.mvp.proxy.InjectPresenter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lhj.function_mudule.R
import com.lhj.libbase.utils.MyLogger


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

    private var bluetoothManager:BluetoothManager?=null
    private var bluetoothAdapter:BluetoothAdapter?=null

    override fun initView() {
        super.initView()
        setOnClick(bind.tvBtn)
        initBle()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        bind.recyclerview.layoutManager = LinearLayoutManager(this)
        bind.recyclerview.adapter = adapter
    }

    private fun startScan() {
        bluetoothAdapter?.startLeScan(callBack)
    }

    override fun onStop() {
        super.onStop()
        stopScan()
    }

    private val callBack = object :BluetoothAdapter.LeScanCallback{
        override fun onLeScan(device: BluetoothDevice?, rssi: Int, scanRecord: ByteArray?) {
            device?.name?.takeIf { it.isNotEmpty() }?.run {
                MyLogger.e("fond device-->$this")
                    adapter.data.forEach{
                        if ((it.name + it.address) ==(device?.name + device?.address)){
                            return
                        }
                    }
//                if (this =="Bluetooth BP"){
                    handler?.sendMessage(Message().apply {
                        obj = device
                        what = 0x14
                    })
//                }
            }
        }
    }

    private val handler = object :Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when(msg.what){
                0x14 ->{
                    adapter.data.add(0,msg.obj as BluetoothDevice)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    private val adapter = object : BaseQuickAdapter<BluetoothDevice, BaseViewHolder>(R.layout.modulefunction_item_ble,null) {
        override fun convert(holder: BaseViewHolder, item: BluetoothDevice) {
            holder.setText(R.id.tv_title, item.name)
        }
    }

    private fun initBle() {
        if (isSupportBle()){
            bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        }
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        bluetoothAdapter?.takeUnless { it.isEnabled }?.run {
            startActivity(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE))
        }
        bluetoothAdapter?.enable()
    }

    /**
     * is support ble?
     *
     * @return
     */
    fun isSupportBle(): Boolean {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2
                && applicationContext.packageManager
            .hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE))
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when(v){
            bind.tvBtn ->{
                adapter.data.clear()
                adapter.notifyDataSetChanged()
                stopScan()
                startScan()
            }
        }
    }

    private fun stopScan(){
        bluetoothAdapter?.stopLeScan(callBack)
    }
}