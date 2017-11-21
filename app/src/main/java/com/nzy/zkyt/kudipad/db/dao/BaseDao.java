package com.nzy.zkyt.kudipad.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.nzy.zkyt.kudipad.model.GoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：宁震宇on 2017/11/17.
 * 邮箱：348723352@qq.com
 * 本类作用：操作数据库表的基类，每张表对应一个操作类，实现增删改查
 */

public class BaseDao<T> {
    protected DBHelper dbHelper;

    public BaseDao(Context context) {
        dbHelper = DBUtil.getInstance(context).getDbHelper();
    }

    /**
     * 数据插入
     * @param table
     * @param nullColumnHack
     * @param values
     * @return
     */
    public long insert(String table, String nullColumnHack, ContentValues values) {
        long ret = 0;
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.beginTransaction();
        try {
            ret = database.insert(table, nullColumnHack, values);
            database.setTransactionSuccessful();
        } catch (RuntimeException e) {
        } finally {
            database.endTransaction();
        }
        return ret;
    }
    public long insertAll(String table, String nullColumnHack, List<ContentValues> values) {
        long ret = 0;
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.beginTransaction();
        try {
            for (ContentValues contentValues:values){
                database.insert(table, nullColumnHack, contentValues);
            }
            database.setTransactionSuccessful();
        } catch (RuntimeException e) {
        } finally {
            database.endTransaction();
        }
        return ret;
    }
    /**
     * 数据查询

     * @return
     */

    public List<GoodItem> queryCode() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        List<GoodItem> list=new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from tgooditem",null);
        Log.i("aaaaaaaaaaaaa", "游标" +cursor.getColumnCount());

        if (cursor != null && cursor.getCount() > 0) {
//            while (cursor.moveToNext()) {
//                GoodItem goodItem =new GoodItem();
//                goodItem.setCode(cursor.getString(0));
//                goodItem.setName(cursor.getString(1));
//                goodItem.setClasscode(cursor.getString(2)) ;
//                goodItem.setClassname(cursor.getString(3));
//                goodItem.setBarcode(cursor.getString(4));
//                goodItem.setSpec(cursor.getString(5));
//                goodItem.setUnit(cursor.getString(6));
//                goodItem.setPrice(cursor.getDouble(9));
//                goodItem.setBachprice(cursor.getDouble(10));
//                goodItem.setStorecount(cursor.getDouble(11));
//                list.add(goodItem);
//            }
           list = queryResult(cursor);
            cursor.close();
        }
        db.close();
        return list;
    }
    public  List<T> query(String table,List<String> keys) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        List<T> results = new ArrayList<T>();
        Cursor cursor = db.rawQuery("select * from "+table,null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.close();
        }
        db.close();
        return results;
    }
    public <T> List<T> query(String table) {
        List<T> results = new ArrayList<T>();
        Cursor cursor = null;
        try {
            cursor = dbHelper.getReadableDatabase().query(table, null, null, null, null, null, null);
            results = queryResult(cursor);
            Log.i("aaaaaaaaaaaaa",results.size()+"");
        } catch (RuntimeException e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return results;
    }

    /**
     * 转换为对象
     * @param cursor
     * @param <T>
     * @return
     */
    public <T> List<T> queryResult(Cursor cursor) {
        throw new RuntimeException("Please overwrite method.");
    }

    /**
     * 数据更新
     * @param table
     * @param values
     * @param whereClause
     * @param whereArgs
     * @return
     */
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        int ret = 0;
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.beginTransaction();
        try {
            ret = database.update(table, values, whereClause, whereArgs);
            database.setTransactionSuccessful();
        } catch (RuntimeException e) {
        } finally {
            database.endTransaction();
        }
        return ret;
    }

    /**
     * 数据删除
     * @param table
     * @param whereClause
     * @param whereArgs
     * @return
     */
    public int delete(String table, String whereClause, String[] whereArgs) {
        int ret = 0;
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.beginTransaction();
        try {
            ret = database.delete(table, whereClause, whereArgs);
            database.setTransactionSuccessful();
        } catch (RuntimeException e) {
        } finally {
            database.endTransaction();
        }
        return ret;
    }
    public int delete(String tablename) {
        return delete(tablename, null, null);
    }
}
