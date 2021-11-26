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
    const val coroutines = "1.3.9"
    const val arouterApi = "1.5.0"
    const val arouterCompiler = "1.2.2"
    const val material = "1.3.0"
}

object AndroidX {
    const val core = "androidx.core:core-ktx:1.3.2"
    const val appcompat = "androidx.appcompat:appcompat:1.2.0"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"

}

object Kotlin{
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
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