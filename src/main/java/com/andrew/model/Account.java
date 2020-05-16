package com.andrew.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
public class Account implements Serializable {

    private Integer id;
    private String accountName;
    private byte[] password;

    public Account(){

    }

    public Account(Integer id, String accountName, byte[] password) {
        this.id = id;
        this.accountName = accountName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", password=" + Arrays.toString(password) +
                '}';
    }
}
