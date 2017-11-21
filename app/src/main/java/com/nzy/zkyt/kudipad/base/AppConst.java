package com.nzy.zkyt.kudipad.base;

import android.os.Environment;

/**
 * 作者：宁震宇on 2017/11/1.
 * 邮箱：348723352@qq.com
 * 本类作用：全局常量    sssss
 */

public class AppConst {
    public static final String TAG = "CSDN_LQR";
    public static final class User {
        public static final String ID = "id";
        public static final String PHONE = "phone";
        public static final String TOKEN = "token";
    }
    public static final String SD_Directory= Environment.getExternalStorageDirectory().getPath();
    public static final String KUDI_PATH=SD_Directory+"/kudipets";
    public static final String GOODS_PATH=KUDI_PATH + "/goods.xls";

}
