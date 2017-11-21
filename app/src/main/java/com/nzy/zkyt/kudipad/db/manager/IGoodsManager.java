package com.nzy.zkyt.kudipad.db.manager;

import com.nzy.zkyt.kudipad.model.GoodItem;

import java.util.List;

/**
 * 作者：宁震宇on 2017/11/17.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public interface IGoodsManager {
    long addAllUser(List<GoodItem> goodItemList);
    void delete();
    List<GoodItem> queryGoodsUsers();
}
