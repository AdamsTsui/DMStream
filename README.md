
# 直播项目

## 目录结构
- [开发环境](#1.0.0)
- [更新日志](#2.0.0)
- [项目中使用到的三方库说明](#3.0.0)

<h2 id="1.0.0"> 一.开发环境</h2>

 开发工具:AndroidStudio2.2
 语言:JAVA
 SDK版本:25
 JDK版本:1.8
  
<h2 id="2.0.0">二.更新日志 </h2>
 
###

---


* 1.主UI框架搭建
	
* 2.项目框架封装（包括网络，图片等）
	
* 3.封装项目中使用到的三方库，工具类等
	
* 4.针对申请Android6.0权限问题进行处理
	
* 5.接口抓取（首页，直播，视频模块接口完成度60%）
 
* 6.加入Android适配方案（百分比适配与Dimens适配）
	
* 7.书写业务逻辑（首页，直播，视频模块逻辑）
	
* 8.使用Vitamio作为直播流媒体播放器

* 9.添加视频弹幕功能（扩展弹幕show,hide等！）

* 10.绘制播放Loading动画

* 11.添加直播视频控制界面

* 12.添加直播手势控制（音量，亮度等）

---


<h2 id="3.0.0">三.三方库说明</h2>
   
   
 ```
   //     适配
    compile 'com.zhy:autolayout:1.4.5'
    //黄油刀
    compile 'com.jakewharton:butterknife:8.1.0'
    apt 'com.jakewharton:butterknife-compiler:8.1.0'
    //提示框，消息框等
    compile 'com.github.GaoYin2016:Android-SVProgressHUD:1.0'
    //    侧滑返回
    compile 'me.imid.swipebacklayout.lib:library:1.0.0'
    //RxJava and RxAndroid
    compile 'io.reactivex:rxjava:1.1.8'
    compile 'io.reactivex:rxandroid:1.2.1'
    // permissions
    compile 'com.tbruyelle.rxpermissions:rxpermissions:0.9.0@aar'
    //RxLifecycle 内存泄露
    compile 'com.trello:rxlifecycle:0.6.1'
    compile 'com.trello:rxlifecycle-components:0.6.1'
    compile 'com.android.support:appcompat-v7:25.0.1'
    compile 'com.android.support:recyclerview-v7:25.0.1'
    //    网络依赖库日志打印
    compile 'com.squareup.okhttp3:logging-interceptor:3.3.1'
    //Retrofit2
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
    // log管理
    compile 'com.orhanobut:logger:1.15'
    compile files('libs/tbs_sdk_thirdapp_v2.5.0.1031_36880_sharewithdownload_obfs_20161107_154437.jar')
    //-------图片框架------
    compile 'com.facebook.fresco:fresco:0.12.0'
    compile 'com.facebook.fresco:imagepipeline-okhttp3:0.12.0'
    // 在 API < 14 上的机器支持 WebP 时，需要添加
    compile 'com.facebook.fresco:animated-base-support:0.12.0'

    // 支持 GIF 动图，需要添加
    compile 'com.facebook.fresco:animated-gif:0.12.0'
    // 支持 WebP （静态图+动图），需要添加
    compile 'com.facebook.fresco:animated-webp:0.12.0'
    compile 'com.facebook.fresco:webpsupport:0.12.0'
    // 仅支持 WebP 静态图，需要添加
    compile 'com.facebook.fresco:webpsupport:0.12.0'
    compile files('libs/tbs_sdk_thirdapp_v2.5.0.1037_36880_minsize_obfs_20161110_102536.jar')
    //TabLayout
    compile 'com.flyco.tablayout:FlycoTabLayout_Lib:2.1.0@aar'
//    轮播图
    compile 'cn.bingoogolapple:bga-banner:2.1.5@aar'
    compile 'com.android.support:support-v4:25.0.1'
//    eventbus
    compile 'org.greenrobot:eventbus:3.0.0'
//    视频播放器
    compile project(path: ':InitActivity')
////    adapter
    compile 'com.github.CymChad:BaseRecyclerViewAdapterHelper:2.7.7'
//    弹幕
    compile 'com.github.ctiao:DanmakuFlameMaster:0.4.6'
   
 ```
  ---

---

