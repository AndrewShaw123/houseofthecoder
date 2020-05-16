package com.andrew.model;

import java.io.Serializable;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
public class SessionUser implements Serializable {

    private Integer accountId;
    private String username;
    private String userImg;
    private String role;

    public SessionUser(){

    }

    public SessionUser(Integer accountId, String username, String userImg, String role) {
        this.accountId = accountId;
        this.username = username;
        this.userImg = userImg;
        this.role = role;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SessionUser{" +
                "accountId=" + accountId +
                ", username='" + username + '\'' +
                ", userImg='" + userImg + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
