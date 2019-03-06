package com.yy.POJO;

public class Account {
    private Integer aid;

    private Integer uid;

    private Float money;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Account(Integer aid, Integer uid, Float money) {
        this.aid = aid;
        this.uid = uid;
        this.money = money;
    }

    public Account(Float money) {
        this.money = money;
    }
}