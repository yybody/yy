package com.yy.POJO;

import java.util.List;

public class Role {
    private Integer rid;

    private String rolename;
    List<Rolejd> rolejd;

    public Role(Integer rid, String rolename, List<Rolejd> rolejd) {
        this.rid = rid;
        this.rolename = rolename;
        this.rolejd = rolejd;
    }

    public List<Rolejd> getRolejd() {
        return rolejd;
    }

    public void setRolejd(List<Rolejd> rolejd) {
        this.rolejd = rolejd;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Role() {
    }
}