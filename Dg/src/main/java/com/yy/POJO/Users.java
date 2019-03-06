package com.yy.POJO;

public class Users {
    private Integer uid;

    private String uname;

    private String psword;

    private String nickename;

    private String address;

    private String phone;

    private String hobby;

    private String introduction;

    private Integer valid;

    private String role;

    private String email;

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    Role roles;
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPsword() {
        return psword;
    }

    public void setPsword(String psword) {
        this.psword = psword == null ? null : psword.trim();
    }

    public String getNickename() {
        return nickename;
    }

    public void setNickename(String nickename) {
        this.nickename = nickename == null ? null : nickename.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Users() {
    }

    public Users(Integer uid, String uname, String psword, String nickename, String address, String phone, String hobby, String introduction, Integer valid, String role, String email, Role roles) {
        this.uid = uid;
        this.uname = uname;
        this.psword = psword;
        this.nickename = nickename;
        this.address = address;
        this.phone = phone;
        this.hobby = hobby;
        this.introduction = introduction;
        this.valid = valid;
        this.role = role;
        this.email = email;
        this.roles = roles;
    }

    public Users(String uname, String psword, String email, String nickename) {
        this.uname = uname;
        this.psword = psword;
        this.email = email;
        this.nickename = nickename;
    }
    public Users(String email) {

        this.email = email;

    }
}