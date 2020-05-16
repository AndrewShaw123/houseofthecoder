package com.andrew.service.signinsignupservice;

import com.andrew.annotation.MyLog;
import com.andrew.model.LoginResultEnum;

import java.sql.Timestamp;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
public interface SigninService {

    /**
     * 登录功能服务
     *
     * @param username 登录名
     * @param password 密码
     * @param loginIpAddr 登录的ip地址
     * @param loginTime 登录时间
     * @return 查询登录的结果（枚举类）包含跳转的页面及跳转信息
     */
    LoginResultEnum login(String username,String password, String loginIpAddr, Timestamp loginTime);

    /**
     * 保存用户的登录时间，和登录ip地址
     *
     * @param accountId 唯一标识用户的id号
     * @param loginIpAddr 登录IP地址
     * @param loginTime 登录时间
     */
    void saveUserLoginIpAndTime(Integer accountId,String loginIpAddr, Timestamp loginTime);

}
