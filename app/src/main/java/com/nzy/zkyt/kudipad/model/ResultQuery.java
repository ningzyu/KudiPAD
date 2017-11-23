package com.nzy.zkyt.kudipad.model;

/**
 * Created by NZY on 2017/6/26.
 */

public class ResultQuery {


    /**
     * compression : 0
     * format : json
     * info : 执行成功
     * sign : 8EAF0D604F89C13CE52BC5CA6EA2DD74
     * status : 1
     * value : {"SELECT_RECEIPTITEM":{"exec0":[["RTAAAAAA201702100012",1,"413076","855602005003",12,12,0,1,40.0002,-1,0,0,0,480,17,13,"0","","","-",0,0,"-","","14010104","21","卫仕红狗营养膏120g","00","个","0","0","0",1,"","","","","","卫仕红狗营养膏120g",0,120,1440],["RTAAAAAA201702100012",2,"413035","6952641600092",4,4,0,1,38.2473,-1,0,0,0,152.99,17,17,"0","","","-",0,0,"-","","14010104","21","*卫仕U0011复合维生素400片（N011）","00","瓶","0","0","0",1,"","","","","","*卫仕U0011复合维生素400片（N011）",0,95,380]],"fieldName":["SHEETID","SERIALID","GOODSID","BARCODE","ORDERQTY","QTY","GIFTQTY","PKNUMBER","COST","RATIONPRICE","NEWFLAG","PROMFLAG","STOCKQTY","COSTVALUE","COSTTAXRATE","SALETAXRATE","GOODSCOSTID","NOTE","RKDATE","WHSCODE","YSQTY","LYQTY","LYWHSCODE","PRODATE","CATEGORYID","BRANDID","GOODSLNAME","UNITID","UNITNAME","DIM0","DIM1","DIM2","PKQTY","VAR1","VAR2","VAR3","VAR4","VAR5","GOODSNAME","GOODSOP","SPRICE","SPRICEVALUE"],"fieldType":["S","N","S","S","N","N","N","N","N","N","N","N","N","N","N","N","S","S","D","S","N","N","S","D","S","S","S","S","S","S","S","S","N","S","S","S","S","S","S","N","N","N"]}}
     */

    private String compression;
    private String format;
    private String info;
    private String sign;
    private String status;
    private String value;

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
