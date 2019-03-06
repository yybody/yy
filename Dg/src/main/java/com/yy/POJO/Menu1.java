package com.yy.POJO;

public class Menu1 {
    private Integer m1id;

    private String m1name;

    public Integer getM1id() {
        return m1id;
    }

    public void setM1id(Integer m1id) {
        this.m1id = m1id;
    }

    public String getM1name() {
        return m1name;
    }

    public void setM1name(String m1name) {
        this.m1name = m1name == null ? null : m1name.trim();
    }

    public Menu1() {
    }

    public Menu1(Integer m1id, String m1name) {
        this.m1id = m1id;
        this.m1name = m1name;
    }

    public Menu1(Integer m1id) {
        this.m1id = m1id;
    }
}