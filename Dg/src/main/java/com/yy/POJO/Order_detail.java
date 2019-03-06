package com.yy.POJO;

public class Order_detail {
    private Integer odid;

    private Integer oid;

    private Integer gid;

    private Float gprice;

    private Integer qty;

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Float getGprice() {
        return gprice;
    }

    public void setGprice(Float gprice) {
        this.gprice = gprice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }


    public Order_detail(Integer oid, Integer gid, Float gprice, Integer qty) {
        this.oid = oid;
        this.gid = gid;
        this.gprice = gprice;
        this.qty = qty;
    }
}