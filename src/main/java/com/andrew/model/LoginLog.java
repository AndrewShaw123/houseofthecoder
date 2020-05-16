package com.andrew.model;

import java.sql.Timestamp;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/8
 */
public class LoginLog {

    private Integer logId;
    private Integer accountId;
    private Timestamp loginTime;
    private String loginAddr;

    public LoginLog(){

    }

    public LoginLog(Integer logId, Integer accountId, Timestamp loginTime, String loginAddr) {
        this.logId = logId;
        this.accountId = accountId;
        this.loginTime = loginTime;
        this.loginAddr = loginAddr;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginAddr() {
        return loginAddr;
    }

    public void setLoginAddr(String loginAddr) {
        this.loginAddr = loginAddr;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "logId=" + logId +
                ", accountId=" + accountId +
                ", loginTime=" + loginTime +
                ", loginAddr='" + loginAddr + '\'' +
                '}';
    }
}
