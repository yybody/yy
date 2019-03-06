package com.yy.POJO;

import java.util.List;

public class Jurisdiction {
    private Integer jid;

    private String jname;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public Jurisdiction(Integer jid, String jname) {
        this.jid = jid;
        this.jname = jname;
    }

    public Jurisdiction() {}
}