package com.nzy.zkyt.kudipad.db.manager;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.nzy.zkyt.kudipad.db.dao.BaseDao;
import com.nzy.zkyt.kudipad.db.DBConstant;
import com.nzy.zkyt.kudipad.model.GoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：宁震宇on 2017/11/17.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public class GoodsDao  extends BaseDao<GoodItem> implements IGoodsManager {

    public GoodsDao(Context context) {
        super(context);
    }
    @Override
    public long addAllUser(List<GoodItem> goodsItemList) {
        List<ContentValues> values=new ArrayList<>();
        for (GoodItem goodsItem: goodsItemList){
            values.add(getContentValues(goodsItem));
        }
        return insertAll(DBConstant.TABLE_USER,null,values);
    }

    @Override
    public void delete() {
        int i=delete(DBConstant.TABLE_USER);
        Log.i("1117","删除结果---"+i);
//        delete(DBConstant.TABLE_USER,"id = ?",new String[]{id+""});
    }

    @Override
    public List<GoodItem> queryGoodsUsers() {
//        List<GoodItem> list = query(DBConstant.TABLE_USER,null,null, null, null, null, null,null);
//        List<GoodItem> list = queryCode();
        List<GoodItem> list = query(DBConstant.TABLE_USER);
//        if(list != null && !list.isEmpty())
//        {
            return list;
//        }
//        return null;
    }

    /**
     * 更新数据
     * @param
     */
//    public void update(GoodItem goodItem) {
//        ContentValues cv = getContentValues(goodItem);
//        cv.remove("id");
////        update(DBConstant.TABLE_USER,cv,"code = ?",new String[]{goodItem.getCode()+""});
//    }

//    /**
//     * 查询所有数据
//     * @return
//     */
//    public List<User> readAllUsers() {
//        List<User> list = query(DBConstant.TABLE_USER,null,null, null, null, null, null,null);
//        if(list != null && !list.isEmpty())
//        {
//            return list;
//        }
//        return null;
//    }
//
//    @Override
//    public  List<User> queryResult(Cursor cursor) {
//        List<User> userList = new ArrayList<User>();
//        User user;
//        while (cursor.moveToNext()) {
//            user = new User();
//            user.setId(cursor.getInt(cursor.getColumnIndex("id")));
//            user.setUserName(cursor.getString(cursor.getColumnIndex("user_name")));
//            user.setAge(cursor.getInt(cursor.getColumnIndex("user_age")));
//            userList.add(user);
//        }
//        return userList;
//    }
//
    private ContentValues getContentValues(GoodItem goodItem) {
        ContentValues values = new ContentValues();
        values.put("code", goodItem.getCode());
        values.put("name", goodItem.getName());
        values.put("classcode", goodItem.getClasscode());
        values.put("classname", goodItem.getClassname());
        values.put("brand", goodItem.getBrandcode());
        values.put("brandname", goodItem.getBrandname());
        values.put("barcode", goodItem.getBarcode());
        values.put("spec", goodItem.getSpec());
        values.put("unit", goodItem.getUnit());
        values.put("bachprice", goodItem.getBachprice());
        values.put("price", goodItem.getPrice());
        values.put("storecount", goodItem.getStorecount());
        return values;
    }


}
