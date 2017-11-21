package com.nzy.zkyt.kudipad.base;

/**
 * 作者：宁震宇on 2017/11/1.
 * 邮箱：348723352@qq.com
 * 本类作用：BaseApp的拓展，用于设置其他第三方的初始化
 */

public class MyApp extends BaseApp{

    @Override
    public void onCreate() {
        super.onCreate();
        //一些第三方的初始化

        //初始化
//        Sys.Lib_PowerOff();
//        SleepMs(300);
//        Sys.Lib_PowerOn();
//        SleepMs(300);
    }
}
