package com.lhj.function_mudule.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.lhj.function_mudule.R
import com.lhj.function_mudule.databinding.ActivityViewpager2Binding
import com.lhj.libbase.base.mvp.BaseMvpActivity
import com.lhj.libbase.utils.MyLogger


/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2022/1/24 23:29
 * @Version: 0.1
 */
class ViewPager2Activity:BaseMvpActivity() {
    override val bind by getBind<ActivityViewpager2Binding>()
    private var dataSize = 5

    override fun initView() {
//        bind.viewpager2.adapter = HorizontalVpAdapter()
        bind.viewpager2.adapter = object :FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return dataSize
            }

            override fun createFragment(position: Int): Fragment {
                return MyFragment.create(position)
            }
        }
        bind.viewpager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                MyLogger.e("onPageSelected-->${position}")
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                MyLogger.e("onPageScrollStateChanged-->${state}")
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                MyLogger.e("onPageScrolled-->${position}")
            }
        })
        bind.viewpager2.adapter?.registerAdapterDataObserver(object :RecyclerView.AdapterDataObserver(){
            override fun onChanged() {
                super.onChanged()
                MyLogger.e("onChanged")
            }

            override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                super.onItemRangeChanged(positionStart, itemCount)
                MyLogger.e("onItemRangeChanged-->${positionStart}-->${itemCount}")
            }

            override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
                super.onItemRangeChanged(positionStart, itemCount, payload)
                MyLogger.e("onItemRangeChanged-->${positionStart}-->${itemCount}")
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                MyLogger.e("onItemRangeInserted-->${positionStart}-->${itemCount}")
            }

            override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                super.onItemRangeMoved(fromPosition, toPosition, itemCount)
                MyLogger.e("onItemRangeMoved-->${fromPosition}-->${itemCount}-->${toPosition}")
            }

            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                super.onItemRangeRemoved(positionStart, itemCount)
                MyLogger.e("onItemRangeRemoved-->${positionStart}-->${itemCount}")
            }

        })
        setOnClick(bind.addFragemnt,bind.delFragemnt)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when(v){
            bind.addFragemnt ->{
                dataSize++
                bind.viewpager2.adapter?.notifyDataSetChanged()
            }
            bind.delFragemnt ->{
                dataSize--
                bind.viewpager2.adapter?.notifyDataSetChanged()
            }
        }
    }

    class MyFragment:Fragment(){
        private val backgrounds = mutableListOf(android.R.color.holo_blue_bright,android.R.color.holo_red_dark,android.R.color.holo_green_dark,
            android.R.color.holo_orange_light,android.R.color.holo_purple)
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.item_viewpager,null)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            arguments?.getInt("position")?.run {
                view.findViewById<TextView>(R.id.tv_hv).text = this.toString()
                view.findViewById<ImageView>(R.id.iv_background).setBackgroundColor(resources.getColor(if (this>=backgrounds.size) backgrounds[this%backgrounds.size] else backgrounds[this]))
            }

        }

        companion object{
            fun create(position: Int):MyFragment{
                return MyFragment().apply {
                    arguments = Bundle().apply {
                        putInt("position",position)
                    }
                }
            }
        }
    }

//    inner class FragmentAdapter :FragmentStateAdapter(this){
//        private var data = mutableListOf<MyFragment>()
//        override fun getItemCount(): Int {
//            return data.size
//        }
//
//        override fun createFragment(position: Int): Fragment {
//            return MyFragment.create(position)
//        }
//
//    }

    inner class HorizontalVpAdapter:RecyclerView.Adapter<HorizontalVpAdapter.HorizontalVpViewHolder>(){
        private val backgrounds = mutableListOf(android.R.color.holo_blue_bright,android.R.color.holo_red_dark,android.R.color.holo_green_dark,
            android.R.color.holo_orange_light,android.R.color.holo_purple)
        inner class HorizontalVpViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            var mTextView: TextView = itemView.findViewById(R.id.tv_hv)
            val mBgContainer: ConstraintLayout = itemView.findViewById(R.id.bg_container)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalVpViewHolder {
            return HorizontalVpViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_viewpager,null).apply {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
            })
        }

        override fun onBindViewHolder(holder: HorizontalVpViewHolder, position: Int) {
            holder.mTextView.text = "第  " + (position + 1) + " 界面"
            holder.mBgContainer.setBackgroundColor(backgrounds[position])
        }

        override fun getItemCount(): Int {
            return backgrounds.size
        }
    }
}