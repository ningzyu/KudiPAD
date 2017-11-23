package com.nzy.zkyt.kudipad.model;

import android.text.TextUtils;

import com.nzy.zkyt.kudipad.base.AppConst;
import com.nzy.zkyt.kudipad.util.SPUtils;
import com.nzy.zkyt.kudipad.util.UIUtils;

/**
 * 作者：宁震宇on 2017/11/17.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public class Setting {

    public static String getShop_Id() {
        return SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.Settings.SHOP_ID,"");
    }

    public static String getIP() {
        return SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.Settings.IP, "");
    }

    public static String getPort() {
        return SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.Settings.PORT, "");
    }
    public static boolean isExist() {
        if (TextUtils.isEmpty(getShop_Id())){
            return false;
        }else if(TextUtils.isEmpty(getIP())){
            return false;
        }else if(TextUtils.isEmpty(getPort())){
            return false;
        }else {
            return true;
        }
    }
    public static void save(String shopid, String ip, String port) {
        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Settings.SHOP_ID, shopid);
        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Settings.IP, ip);
        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.Settings.PORT, port);
    }

    public static void clear() {
        SPUtils.getInstance(UIUtils.getContext()).remove(AppConst.Settings.SHOP_ID);
        SPUtils.getInstance(UIUtils.getContext()).remove(AppConst.Settings.IP);
        SPUtils.getInstance(UIUtils.getContext()).remove(AppConst.Settings.PORT);
//        DBManager.getInstance().deleteAllUserInfo();
    }
}
