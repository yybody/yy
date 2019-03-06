package com.yy.POJO;

public class Goods {
    private Integer gid;

    private String gname;

    private Integer m2id;

    private Float gprice;//价格

    private String unit;//商品单位

    private Float gdiscount;//折扣

    private String ad;//宣传语

    private String supplier;//供货商

    private Integer qty;//库存量0

    private String brand;//品牌

    private String gpic;//商品图片

    private Integer valid;//是否有效

    private String gdesc;//商品详细信息

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Integer getM2id() {
        return m2id;
    }

    public void setM2id(Integer m2id) {
        this.m2id = m2id;
    }

    public Float getGprice() {
        return gprice;
    }

    public void setGprice(Float gprice) {
        this.gprice = gprice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Float getGdiscount() {
        return gdiscount;
    }

    public void setGdiscount(Float gdiscount) {
        this.gdiscount = gdiscount;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad == null ? null : ad.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getGpic() {
        return gpic;
    }

    public void setGpic(String gpic) {
        this.gpic = gpic == null ? null : gpic.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc == null ? null : gdesc.trim();
    }

    public Goods(Integer gid, String gname, Float gprice, Float gdiscount) {
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
        this.gdiscount = gdiscount;
    }

    public Goods() {
    }

    public Goods(Integer gid, String gname, Integer m2id, Float gprice, String unit, Float gdiscount, String ad, String supplier, Integer qty, String brand, String gpic, Integer valid, String gdesc) {
        this.gid = gid;
        this.gname = gname;
        this.m2id = m2id;
        this.gprice = gprice;
        this.unit = unit;
        this.gdiscount = gdiscount;
        this.ad = ad;
        this.supplier = supplier;
        this.qty = qty;
        this.brand = brand;
        this.gpic = gpic;
        this.valid = valid;
        this.gdesc = gdesc;
    }



}