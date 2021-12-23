package com.lhj.function_mudule

import java.util.*

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description: leetcode经典算法题
 * @Author: liuhuajian
 * @CreateDate： 2021/12/15 11:16
 * @Version: 0.1 {@link MyLogger}
 */
object Algorithm {

    /**
     * 两数之和
     * 用哈希表来存储，优化传统方式
     */
    fun addTowNumber(intArray: IntArray,target:Int):IntArray{
        val result = IntArray(2)
        val hashtable = Hashtable<Int, Int>()
        for (index in intArray.indices){
            if (hashtable.containsKey(target - intArray[index])){
                return result.apply {
                    set(0, hashtable[target - intArray[index]]!!)
                    set(1,index)
                }
            }
            hashtable[intArray[index]] = index
        }
        return result
    }
}