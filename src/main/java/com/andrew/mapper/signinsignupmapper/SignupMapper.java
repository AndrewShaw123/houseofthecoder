package com.andrew.mapper.signinsignupmapper;

import com.andrew.model.Account;
import com.andrew.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * 注册功能需要访问到的数据库的方法类
 *
 * @author andrew
 * @date 2020/1/7
 */
public interface SignupMapper {

    /**
     * 插入Account表，插入用户的登录名和密码
     *
     * @param account 注册的账号信息，包含登录名和密码
     * @return 唯一识别用户账号信息的id号
     */
    Integer insertAccountNameAndPassword(@Param("account") Account account);

    /**
     * 查询传入的登录名是否存在
     *
     * @param username 登录名
     * @return 查找到的账号信息，没有则为null
     */
    Account queryByUserName(@Param("username") String username);

    /**
     * 插入用户的个人信息
     *
     * @param user 用户的个人信息,包含唯一识别用户账号信息的id号,昵称,用户头像
     */
    void insertUserNameInUser(@Param("user") User user);

    /**
     * 插入用户的角色信息
     *
     * @param accountId 唯一识别用户账号信息的id号
     * @param roleName 角色名称
     */
    void insertUserRole(@Param("accountId")Integer accountId,@Param("roleName")String roleName);
}
