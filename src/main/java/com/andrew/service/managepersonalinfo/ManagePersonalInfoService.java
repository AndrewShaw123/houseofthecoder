package com.andrew.service.managepersonalinfo;

import com.andrew.model.SessionUser;
import com.andrew.model.User;

/**
 * Class
 *
 * @author andrew
 * @date 2020/1/9
 */
public interface ManagePersonalInfoService {

    /**
     * 根据用户id查询用户个人信息
     *
     * @param accountid 用户id
     * @return 用户个人信息
     */
    User getPersonalInfo(Integer accountid);

    /**
     * 更新用户的个人信息
     *
     * @param user  用户信息
     */
    void updatePersonalInfo(User user);

    /**
     * 更新用户头像
     *
     * @param userImg 头像名称
     * @param accountId 用户id
     */
    void updatePersonalImg(String userImg,Integer accountId);

    /**
     * 修改密码
     *
     * @param accountId 用户id
     * @param password 密码
     */
    void changePassword(Integer accountId,String password);

    User getUserPageInfo(Integer accountId);

}
