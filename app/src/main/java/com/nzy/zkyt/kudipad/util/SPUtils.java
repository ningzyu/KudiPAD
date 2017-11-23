package com.nzy.zkyt.kudipad.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * 作者：宁震宇on 2017/11/1.
 * 邮箱：348723352@qq.com
 * 本类作用：sharedPreferences工具类(单例模式)
 */

public class SPUtils {
    private static final String SP_NAME = "kudi";//这个就是一个名字，随便起
    private static SPUtils mSpUtils;//
    private Context context;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private SPUtils(Context context) {
        this.context = context;
        sp = this.context.getSharedPreferences(SP_NAME, Context.MODE_APPEND);
        editor = sp.edit();
    }

    public static SPUtils getInstance(Context context) {

        if (mSpUtils == null) {
            synchronized (SPUtils.class) {
                if (mSpUtils == null) {
                    mSpUtils = new SPUtils(context);
                    return mSpUtils;
                }
            }
        }

        return mSpUtils;

    }

    public void putBoolean(String key, Boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key, Boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    public void putString(String key, String value) {
        if (key == null) {
            return;
        }
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public Map<String, ?> getAll() {
        return sp.getAll();
    }

    public void remove(String key) {
        sp.edit().remove(key).commit();
    }
}
