package com.yy.POJO;

import java.util.List;

public class Rolejd {
    private Integer rjid;

    private Integer roleid;

    private Integer jdid;



    List<Jurisdiction> jurisdiction;

    public Rolejd() {
    }

    public Rolejd(Integer rjid, Integer roleid, Integer jdid, List<Jurisdiction> jurisdiction) {
        this.rjid = rjid;
        this.roleid = roleid;
        this.jdid = jdid;
        this.jurisdiction = jurisdiction;
    }

    public List<Jurisdiction> getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(List<Jurisdiction> jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Integer getRjid() {
        return rjid;
    }

    public void setRjid(Integer rjid) {
        this.rjid = rjid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getJdid() {
        return jdid;
    }

    public void setJdid(Integer jdid) {
        this.jdid = jdid;
    }
}