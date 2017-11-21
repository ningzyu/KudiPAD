package com.nzy.zkyt.kudipad.db;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.caidongdong.databasedemo.db.DBConstant.java
 * @author: caidongdong
 * @date: 2016-06-25 15:14
 */
public class DBConstant {
    public static final String DB_NAME = "nzy";//数据库名
    public static final int DB_INIT_VERSION = 1;//版本号

    public static final String TABLE_USER = "tgooditem";

    public static final String CREATE_GOOD_TABLE = "create table  tgooditem("
            + "code varchar(100),name varchar(100),classcode varchar(100), classname varchar(100),"
            + "barcode varchar(100),spec varchar(100), unit varchar(100),brand varchar(100), brandname varchar(100)," +
            "price numeric(19,2), bachprice numeric(19,2), storecount numeric(19,2), primary key(code, barcode))";

    public static final String CREATE_STOCK_GOOD = "create table  tstockitem("
            + "code varchar(100),name varchar(100),barcode varchar(100), storecount numeric(19,2), primary key(code, barcode))";
    public static final String CREATE_RECEIVE_GOOD = "create table  treceiveitem("
            + "code varchar(100),name varchar(100),classcode varchar(100), classname varchar(100),"
            + "barcode varchar(100),spec varchar(100), unit varchar(100),brand varchar(100), brandname varchar(100)," +
            "price numeric(19,2), bachprice numeric(19,2), storecount numeric(19,2), primary key(code, barcode))";
    public static final String CREATE_RECEIVENUM_GOOD = "create table  savegoodsnum("
            + "code varchar(100),name varchar(100),sku double(100), allnum int )";











    //        // 更新一组数据
//        LouSQLite.execSQL("update " + MyCallBack.TABLE_NAME_PHRASE
//                + " set " + PhraseEntry.COLEUM_NAME_FAVORITE + "=1 "
//                + "where " + PhraseEntry.COLEUM_NAME_FAVORITE + "=0");
//        query();
//
//        // 删除一个数据
//        LouSQLite.delete(MyCallBack.TABLE_NAME_PHRASE
//                , PhraseEntry.COLEUM_NAME_ID + "=?"
//                , new String[]{phrase.getId()});
}
