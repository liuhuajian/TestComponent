package com.lhj.version

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/11/19 21:06
 * @Version: 0.1
 */
object Versions {
    const val coreKtx = "1.3.2"
    const val appcompat = "1.2.0"
    const val material = "1.3.0"
    const val constraintlayout = "2.0.4"
    const val arouterApi="1.4.0"
    const val arouterCompiler = "1.2.1"
}

object AndroidX{
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
}

object GitHub{
    const val arouterApi = "com.alibaba:arouter-api:${Versions.arouterApi}"
    const val arouterCompiler = "com.alibaba:arouter-compiler:${Versions.arouterCompiler}"
}