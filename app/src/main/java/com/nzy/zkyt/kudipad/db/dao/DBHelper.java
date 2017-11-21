package com.nzy.zkyt.kudipad.db.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.nzy.zkyt.kudipad.db.DBConstant;

import static com.nzy.zkyt.kudipad.db.DBConstant.CREATE_GOOD_TABLE;
import static com.nzy.zkyt.kudipad.db.DBConstant.CREATE_RECEIVENUM_GOOD;
import static com.nzy.zkyt.kudipad.db.DBConstant.CREATE_RECEIVE_GOOD;
import static com.nzy.zkyt.kudipad.db.DBConstant.CREATE_STOCK_GOOD;

/**
 * 作者：宁震宇on 2017/11/17.
 * 邮箱：348723352@qq.com
 * 本类作用：数据库帮助类，控制数据库版本，创建表等
 */

public class DBHelper  extends SQLiteOpenHelper {
    private Context context;
    private int dbVersion;

    public DBHelper(Context context, String dbName, int initVersion) {
        super(context, dbName, null, initVersion);
        this.context = context;
        this.dbVersion = initVersion;
    }
    public DBHelper(Context context) {
       super(context, DBConstant.DB_NAME,null,DBConstant.DB_INIT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for(int i = 1; i <= this.dbVersion; ++i) {
            this.upgradeSqlData(db, i, false);
        }
    }
//
    private void upgradeSqlData(SQLiteDatabase db, int version, boolean isDowngrade) {

        try {
            db.execSQL(CREATE_GOOD_TABLE);
            db.execSQL(CREATE_STOCK_GOOD);
            db.execSQL(CREATE_RECEIVE_GOOD);
            db.execSQL(CREATE_RECEIVENUM_GOOD);
        } catch(SQLException e) {
            Log.i("DBHelper", e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for(int i = oldVersion + 1; i <= newVersion; ++i) {
            this.upgradeSqlData(db, i, false);
        }
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for(int i = oldVersion - 1; i >= newVersion; --i) {
            this.upgradeSqlData(db, i, false);
        }
    }

//    @Override
//    public SQLiteDatabase getWritableDatabase() {
//        File file = new File(DATABASE_PATH + "dbtest");
//        if (!file.exists()) {
//            file.mkdirs();
//
//        }
//        File dbFile = new File(file,"mydb.db");
//        if (!dbFile.exists())
//            try {
//                dbFile.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        return SQLiteDatabase.openOrCreateDatabase(dbFile,null);
//    }
//
//    @Override
//    public SQLiteDatabase getReadableDatabase() {
//        return getWritableDatabase();
//    }
}
