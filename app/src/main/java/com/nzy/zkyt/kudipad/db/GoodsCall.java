package com.nzy.zkyt.kudipad.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nzy.zkyt.kudipad.model.GoodItem;

import java.util.Arrays;
import java.util.List;

import static com.nzy.zkyt.kudipad.db.DBConstant.CREATE_GOOD_TABLE;
import static com.nzy.zkyt.kudipad.db.DBConstant.CREATE_RECEIVENUM_GOOD;
import static com.nzy.zkyt.kudipad.db.DBConstant.CREATE_RECEIVE_GOOD;
import static com.nzy.zkyt.kudipad.db.DBConstant.CREATE_STOCK_GOOD;
import static com.nzy.zkyt.kudipad.db.DBConstant.DB_INIT_VERSION;
import static com.nzy.zkyt.kudipad.db.DBConstant.DB_NAME;
import static com.nzy.zkyt.kudipad.db.DBConstant.TABLE_USER;

/**
 * 作者：宁震宇on 2017/11/20.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public class GoodsCall implements LouSQLite.ICallBack {

    public GoodsCall() {
    }
    @Override
    public List<String> createTablesSQL() {
        return Arrays.asList(
                CREATE_GOOD_TABLE,
                CREATE_STOCK_GOOD,
                CREATE_RECEIVE_GOOD,
                CREATE_RECEIVENUM_GOOD
                );
    }

    @Override
    public String getDatabaseName() {
        return DB_NAME;
    }

    @Override
    public int getVersion() {
        return DB_INIT_VERSION;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 0:
//                db.execSQL(TABLE_SCHEMA_FAVORITE); // 升级操作；
            case 1:
                break;
            default:
                break;
        }
    }


    @Override
    public <T> void assignValuesByEntity(String tableName, T t, ContentValues values) {
        switch (tableName) {
            case TABLE_USER:
                if (t instanceof GoodItem) {
                    GoodItem phrase = (GoodItem) t;
                    values.put("code", phrase.getCode());
                    values.put("name", phrase.getName());
                    values.put("classcode", phrase.getClasscode());
                    values.put("classname", phrase.getClassname());
                    values.put("brand", phrase.getBrandcode());
                    values.put("brandname", phrase.getBrandname());
                    values.put("barcode", phrase.getBarcode());
                    values.put("spec", phrase.getSpec());
                    values.put("unit", phrase.getUnit());
                    values.put("bachprice", phrase.getBachprice());
                    values.put("price", phrase.getPrice());
                    values.put("storecount", phrase.getStorecount());
                }
                break;
        }
    }

    @Override
    public Object newEntityByCursor(String tableName, Cursor cursor) {
        switch (tableName) {
            case TABLE_USER:
                GoodItem goodItem =new GoodItem();
                goodItem.setCode(cursor.getString(0));
                goodItem.setName(cursor.getString(1));
                goodItem.setClasscode(cursor.getString(2)) ;
                goodItem.setClassname(cursor.getString(3));
                goodItem.setBarcode(cursor.getString(4));
                goodItem.setSpec(cursor.getString(5));
                goodItem.setUnit(cursor.getString(6));
                goodItem.setPrice(cursor.getDouble(9));
                goodItem.setBachprice(cursor.getDouble(10));
                goodItem.setStorecount(cursor.getDouble(11));
                return goodItem;
//            case TABLE_NAME_FAVORITE:
//                return new Phrase(
//                        cursor.getString(cursor.getColumnIndex(PhraseEntry.COLEUM_NAME_ID)),
//                        cursor.getString(cursor.getColumnIndex(PhraseEntry.COLEUM_NAME_CONTENT)),
//                        cursor.getInt(cursor.getColumnIndex(PhraseEntry.COLEUM_NAME_FAVORITE))
//                );
        }

        return null;
    }


}