package com.study.spring.entity;

/**
 * @author liuyzh
 * @description: 实体类
 * @date 2019/3/13 14:44
 */
public class UsersEntity {
    private int id;
    private String userName;
    private String password;
    private String telPhone;
    private String cdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", cdate='" + cdate + '\'' +
                '}';
    }
}
