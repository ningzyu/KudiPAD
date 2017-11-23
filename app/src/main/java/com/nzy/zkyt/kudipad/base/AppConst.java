package com.nzy.zkyt.kudipad.base;

import android.os.Environment;

/**
 * 作者：宁震宇on 2017/11/1.
 * 邮箱：348723352@qq.com
 * 本类作用：全局常量    sssss
 */

public class AppConst {
    public static final String TAG = "CSDN_LQR";
    public static final class Settings {
        public static final String SHOP_ID = "shopid";
        public static final String IP = "ip";
        public static final String PORT = "port";
    }
    public static final String SD_Directory= Environment.getExternalStorageDirectory().getPath();
    public static final String KUDI_PATH=SD_Directory+"/kudipets";
    public static final String GOODS_PATH=KUDI_PATH + "/goods.xls";

}
