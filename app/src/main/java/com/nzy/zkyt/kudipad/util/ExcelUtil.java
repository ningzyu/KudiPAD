package com.nzy.zkyt.kudipad.util;

import android.util.Log;

import com.nzy.zkyt.kudipad.model.GoodItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

/**
 * 作者：宁震宇on 2017/11/17.
 * 邮箱：348723352@qq.com
 * 本类作用：
 */

public class ExcelUtil {
    private static ExcelUtil excelUtil;
    private ExcelUtil() {}
    public static ExcelUtil getInstance() {
        if (excelUtil == null) {
            synchronized (SPUtils.class) {
                if (excelUtil == null) {
                    excelUtil = new ExcelUtil();
                    return excelUtil;
                }
            }
        }
        return excelUtil;
    }


    public List<GoodItem> getGoods(File f) {
        Log.i("1117","文件路劲---"+f.getPath());
        List<GoodItem> goodItems = new ArrayList<>();
        for (List<String> list : readExcel(f)) {
            Log.i("1117","读取长度---"+list.size()+"读取结果---"+list.get(0));
            GoodItem tc = new GoodItem();
            tc.setCode(list.get(0));
            tc.setBarcode(list.get(1));
            tc.setClasscode(list.get(2));
            tc.setClassname(list.get(3));
            tc.setBrandcode(list.get(4));
            tc.setBrandname(list.get(5));
            tc.setName(list.get(6));
            tc.setSpec(list.get(7));
            tc.setBachprice(todouble(list.get(8)));
            tc.setPrice(todouble(list.get(9)));
            tc.setStorecount(todouble(list.get(10)));
            goodItems.add(tc);
        }
        return goodItems;
    }

    public static double todouble(String cell) {
        try {
            return Double.parseDouble(cell);
        } catch (NumberFormatException e) {
            return 0.00;
        }
    }

    private List<List<String>> readExcel(File f) {
        List<List<String>> lists = new ArrayList<>();
        try {
            Workbook course = Workbook.getWorkbook(f);
            Sheet sheet = course.getSheet(0);
            Log.i("1117","行---"+sheet.getRows()+"列---"+sheet.getColumns());
            for (int i = 1; i < sheet.getRows(); i++) {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < sheet.getColumns(); j++) {
                    list.add(sheet.getCell(j, i).getContents());
                }
                lists.add(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("1117","readExcel读取长度---"+lists.size());
        return lists;
    }
}
