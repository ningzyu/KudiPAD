package com.nzy.zkyt.kudipad.model;

/**
 * Created by dyl on 17-6-12.
 * 商品实体
 */

public class GoodItem {
    private double viprice = 0.00; //会员价
    private String code; //商品编码
    private String name; //名称
    private String classcode; //商品类别
    private String classname; //商品类别名称
    private String barcode;//条码
    private String spec; //规格
    private String unit; //单位
    private double price = 0.00f;
    private double bachprice = 0.00; //进价
    private double storecount = 0.00; //库存数量
    private String brandcode; //品牌
    private String brandname; //品牌名称

    public GoodItem() {
    }

    @Override
    public String toString() {
        return "GoodItem{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", classcode='" + classcode + '\'' +
                ", classname='" + classname + '\'' +
                ", barcode='" + barcode + '\'' +
                ", spec='" + spec + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", bachprice=" + bachprice +
                ", bachprice=" + viprice +
                ", storecount=" + storecount +
                ", brandcode='" + brandcode + '\'' +
                ", brandname='" + brandname + '\'' +
                '}';
    }

    public GoodItem(String code, String name, String classcode, String classname, String barcode, String spec, String unit, double price, double bachprice, double viprice, double storecount, String brandcode, String brandname) {
        this.code = code;
        this.name = name;
        this.classcode = classcode;
        this.classname = classname;
        this.barcode = barcode;
        this.spec = spec;
        this.unit = unit;
        this.price = price;
        this.bachprice = bachprice;
        this.viprice=viprice;
        this.storecount = storecount;
        this.brandcode = brandcode;
        this.brandname = brandname;
    }

    public double getViprice() {
        return viprice;
    }

    public void setViprice(double viprice) {
        this.viprice = viprice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBachprice() {
        return bachprice;
    }

    public void setBachprice(double bachprice) {
        this.bachprice = bachprice;
    }

    public double getStorecount() {
        return storecount;
    }

    public void setStorecount(double storecount) {
        this.storecount = storecount;
    }

    public String getBrandcode() {
        return brandcode;
    }

    public void setBrandcode(String brandcode) {
        this.brandcode = brandcode;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
}
