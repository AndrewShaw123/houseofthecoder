package com.andrew.service.signinsignupservice;

import com.andrew.model.Account;

/**
 * 注册功能的服务
 *
 * @author andrew
 * @date 2020/1/7
 */
public interface SignupService {

    /**
     * 注册账号服务
     *
     * @param username 注册的登录名
     * @param password 密码
     */
    void signupService(String username,String password);

    /**
     * 检查是否登录名已经存在
     *
     * @param username 登录名
     * @return 查询到的相同的登录名的信息
     */
    Account vaildUserName(String username);

}
