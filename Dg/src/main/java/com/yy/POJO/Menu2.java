package com.yy.POJO;

public class Menu2 {
    private Integer m2id;

    private String m2name;

    private Integer m1id;

    public Integer getM2id() {
        return m2id;
    }

    public void setM2id(Integer m2id) {
        this.m2id = m2id;
    }

    public String getM2name() {
        return m2name;
    }

    public void setM2name(String m2name) {
        this.m2name = m2name == null ? null : m2name.trim();
    }

    public Integer getM1id() {
        return m1id;
    }

    public void setM1id(Integer m1id) {
        this.m1id = m1id;
    }
}