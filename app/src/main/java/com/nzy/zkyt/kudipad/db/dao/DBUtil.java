package com.nzy.zkyt.kudipad.db.dao;

import android.content.Context;

import com.nzy.zkyt.kudipad.db.DBConstant;

/**
 * Aestheticism
 * Created by caidong on 16-6-25.
 * email:mircaidong@163.com
 */
public class DBUtil {
    private static DBUtil instance;
    private static DBHelper dbHelper;
    private DBUtil() {
    }

    public static DBUtil getInstance(Context context) {
        if (instance == null) {
            instance = new DBUtil();
            initDBHelper(context);
        }
        return instance;
    }

    private static void initDBHelper(Context context) {
        dbHelper = new DBHelper(context, DBConstant.DB_NAME,DBConstant.DB_INIT_VERSION);
        dbHelper.onCreate(dbHelper.getWritableDatabase());
    }


    public DBHelper getDbHelper(){
        return dbHelper;
    }
}
