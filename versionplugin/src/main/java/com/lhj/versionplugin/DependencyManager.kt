package com.lhj.versionplugin

/**
 * copyright (C),2021-2022, 国民集团健康科技有限公司
 * @ProjectName:
 * @Description:
 * @Author: liuhuajian
 * @CreateDate： 2021/11/24 10:58
 * @Version: 0.1
 */
object Versions {
    // 低版本分包、64k限制解决
    const val multiDex = "1.0.3"
    const val coreKtx = "1.3.2"
    const val appcompat = "1.3.1"
    const val fragmentKtx = "1.3.0"
    const val constraintlayout = "2.0.4"
    const val androidAnnotation = "1.1.0"

    // 协程基础库
    const val kotlinXCoroutinesCore = "1.5.2"
    // 协程 Android 库，提供 UI 调度器
    const val kotlinXCoroutinesAndroid = "1.5.2"

    const val arouterApi = "1.5.0"
    const val arouterCompiler = "1.2.2"
    const val material = "1.3.0"
}

object AndroidX {
    const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val androidAnnotation = "androidx.annotation:annotation:${Versions.androidAnnotation}"
}

object Kotlin{
    const val kotlinXCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinXCoroutinesCore}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinXCoroutinesAndroid}"
}

object Github {
    const val arouterApi = "com.alibaba:arouter-api:${Versions.arouterApi}"
    const val arouterCompiler = "com.alibaba:arouter-compiler:${Versions.arouterCompiler}"
}

object MultiDex {
    const val packageMultiDex = "com.android.support:multidex:${Versions.multiDex}"
}

object Google {
    const val material = "com.google.android.material:material:${Versions.material}"

}