package com.yy.POJO;

import java.util.Date;

public class Orderg {
    private Integer oid;

    private Integer uid;

    private Date odate;

    private String address;

    private String contactman;

    private Float osum;

    private String dealdate;

    private String status;

    private String note;

    private Integer valid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman == null ? null : contactman.trim();
    }

    public Float getOsum() {
        return osum;
    }

    public void setOsum(Float osum) {
        this.osum = osum;
    }

    public String getDealdate() {
        return dealdate;
    }

    public void setDealdate(String dealdate) {
        this.dealdate = dealdate == null ? null : dealdate.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Orderg(Integer oid, Integer uid, String contactman) {
        this.oid = oid;
        this.uid = uid;
        this.contactman = contactman;
    }



    public Orderg(Integer uid, Date odate, String address, String contactman, Float osum, String dealdate, String status) {
        this.uid = uid;
        this.odate = odate;
        this.address = address;
        this.contactman = contactman;
        this.osum = osum;
        this.dealdate = dealdate;
        this.status = status;

    }
}