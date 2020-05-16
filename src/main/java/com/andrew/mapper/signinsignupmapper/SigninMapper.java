package com.andrew.mapper.signinsignupmapper;

import com.andrew.model.Account;
import com.andrew.model.LoginLog;
import com.andrew.model.SessionUser;
import org.apache.ibatis.annotations.Param;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/7
 */
public interface SigninMapper {

    /**
     * 查询用户的登录名以验证密码
     *
     * @param username 登录名
     * @return 用户账号信息，包含唯一识别用户账号信息的id号,登录名,密码
     */
    Account selectByUsername(@Param("username") String username);

    /**
     * 查询用户角色
     *
     * @param accountId 唯一识别用户账号信息的id号
     * @return 用户所属角色
     */
    String selectRoleByAccountid(@Param("accountid")Integer accountId);

    /**
     * 查询用于存放在session中的数据
     *
     * @param accountId 唯一识别用户账号信息的id号
     * @return 用户登录后需要用到的基本信息，包含唯一识别用户账号信息的id号，用户名，头像
     */
    SessionUser selectBasicSessionInfo(@Param("acccountid") Integer accountId);

    /**
     * 插入用户的登录日志，包括登录的时间和登录的ip地址
     *
     * @param loginLog 用户的登录日志
     */
    void insertUserLoginLog(@Param("loginLog") LoginLog loginLog);

}
