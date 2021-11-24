### 项目介绍
    通过gradle配置结合阿里ARouter实现的组件化开发
### 组件化实现
    1、采用Composing builds统一配置项目配置和导入的第三方包import com.lhj.versionPlugin.*
    2、在工程build.gradle subprojects统一配置apply,读取配置文件中的值，并配置model的运行方式，如下
      if (BuildConfig.moduleFuctionRun) {
          apply plugin: 'com.android.application'
      } else {
          apply plugin: 'com.android.library'
      }
    3、在组件model中创建另一个AndroidManifest.xml文件，当组件以单独项目运行的时候组件使用该文件
      sourceSets {
              main {
                  if (BuildConfig.moduleFuctionRun) {
                      manifest.srcFile 'src/main/manifest/AndroidManifest.xml'
                  } else {
                      manifest.srcFile 'src/main/AndroidManifest.xml'
                  }
              }
          }
### 项目结构
    libbase：基础功能，如基类、工具类、网络请求封装、图片加载封装等，新加的三方库都放到此处
    libres：存放项目图片、通用style、适配文件等其它资源文件
    commonlib：存放项目通用组件，提供给各个组件和主项目使用，如常量、登陆实体类等
    modulefunction： 功能组件
    app：主项目
    versionPlugin： 复合构建，配置属性和三方库导入
    proguard-files：统一配置混淆S
    config：代码规范配置detekt.yml（可通过File-Settings-detekt启用，然后配置此文件夹下文件路径，需要AndroidStudio下载detekt插件，
                                 也可以配置在项目build.gradle中（参考https://github.com/detekt/detekt））
### 依赖关系
    libbase -> libres -> commonlib -> modulefunction -> app
### 有几个需要注意的地方
    1、避免重复依赖，此案例中将所有的依赖库放到跟目录下的build.gradle中，在baselib中使用api方式
    添加全部依赖，在组件中根据运行方式动态设置使用compileOnly依赖或者使用api依赖
    2、组件间跳转，此案例采用的是阿里的ARouter进行跳转的
    
    
    
    
    
