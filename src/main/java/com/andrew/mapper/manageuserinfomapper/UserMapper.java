package com.andrew.mapper.manageuserinfomapper;

import com.andrew.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/9
 */
public interface UserMapper {

    /**
     * 通过用户的accountId查询用户的个人信息
     *
     * @param accountId 用户id号
     * @return 用户个人信息
     */
    User queryUserInfoByAccountId(@Param("accountId") Integer accountId);

    /**
     * 通过用户的accountId更新用户的个人信息
     *
     * @param user 用户的个人信息
     */
    void updateUserInfoByAccountId(@Param("user")User user);

    /**
     * 更新用户头像
     *
     * @param userImg 新头像名字
     * @param accountId 用户id号
     */
    void updateUserImgByAccountId(@Param("userImg")String userImg,@Param("accountId")Integer accountId);

    /**
     * 更新密码
     *
     * @param accountId 用户id
     * @param password 加密后的密码
     */
    void updateUserPasswordByAccountId(@Param("accountId")Integer accountId,@Param("password")byte[] password);

}
