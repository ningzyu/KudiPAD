package com.nzy.zkyt.kudipad.data;

import com.nzy.zkyt.kudipad.model.Setting;
import com.nzy.zkyt.kudipad.util.Md5;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import static com.nzy.zkyt.kudipad.util.ZipUtil.Compres;

/**
 * 作者：宁震宇on 2017/11/22.
 * 邮箱：348723352@qq.com
 * 本类作用：组合传入参数
 */

public class Para {
    /**
     * 获取查询收货单的传入参数-----SHEETID;单据编号
     */
    public static String BILL_RECEIPT = "BILL_RECEIPT";
    public static String BILL_RATION_I = "BILL_RATION_I";
    public static String BILL_TRANSFER_I = "BILL_TRANSFER_I";
    private static Para para;
    private Para() {
    }
    public static Para getInstance() {
        if (para == null) {
            synchronized (Para.class) {
                if (para == null) {
                    para = new Para();
                    return para;
                }
            }
        }
        return para;
    }
    public Map<String, String> getParaQuery(String SELECT,String code,String compression) {
        String paras="";
        if (SELECT.equals(BILL_RECEIPT)){
            paras = "{\"SELECT_RECEIPTITEM\":{\"PARAMETER\":[\"SHEETID = '" + code + "'\"]}}";
        }else if (SELECT.equals(BILL_RATION_I)){
            paras = "{\"SELECT_RATIONITEM_I\":{\"PARAMETER\":[\"SHEETID = '" + code + "'  order by CATEGORYID,SERIALID\"]}}";
        }else if (SELECT.equals(BILL_TRANSFER_I)){
            paras = "{\"SELECT_TRANSFERITEM_I\":{\"PARAMETER\":[\"SHEETID = '" + code + "'\"]}}";
        }
        if (compression.equals("1")){
            return sss(SELECT,Compres(paras),compression);
        }else {
            return sss(SELECT,paras,compression);
        }
    }
    public Map<String, String> getParaQuery(String SELECT,boolean isAPPROVE,String compression) {
        String paras="";
        return sss(SELECT,paras,compression);
    }
    private Map<String, String> sss(String apiid, String para, String compression){
        Map<String, String> map=new HashMap<>();
        String appid="O2OAPP";
        String format="json";
        String exeinfo="{SHOPID=" + Setting.getShop_Id() + ",USERID=" + "用户ID" + "}";//TODO
        String timestamp=getDate("yyyy-MM-dd HH:mm:ss");
        String sign= Md5.md5Capital("UYTGH098E68" + appid + apiid + format + exeinfo + para + compression + timestamp);
        map.put("sign", sign);
        map.put("appid", appid);
        map.put("apiid", apiid);
        map.put("format", format);
        map.put("exeinfo", exeinfo);
        map.put("para", para);
        map.put("compression", compression);
        map.put("timestamp", timestamp);
        return map;
    }
    /**
     * 获得当前时间
     */
    public static String getDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new java.util.Date());
    }
}
