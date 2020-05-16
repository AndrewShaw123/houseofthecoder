package com.andrew.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/6
 */
public class User implements Serializable {

    private Integer accountId;
    private String username;
    private String userImg;
    private String sex;
    private String birthday;
    private String intro;

    public User(){

    }

    public User(Integer accountId, String username, String userImg, String sex, String birthday, String intro) {
        this.accountId = accountId;
        this.username = username;
        this.userImg = userImg;
        this.sex = sex;
        this.birthday = birthday;
        this.intro = intro;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountid=" + accountId +
                ", username='" + username + '\'' +
                ", userImg='" + userImg + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", intro='" + intro + '\'' +
                '}';
    }
}
